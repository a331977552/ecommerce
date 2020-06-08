package com.food.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.Map;

public class JWTUtil {


    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";


    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;

    public static final String APP_SECRET_KEY = "kaobaizi123";

    private static final String ROLE_CLAIMS = "role";
    private static final String ISSUER = "huang";


    /**
     * 生成token
     *
     * @param username
     * @param role
     * @return
     */
    public static String createToken(String username, String key,Integer id,String role) {
        Algorithm algorithm = Algorithm.HMAC256(APP_SECRET_KEY);
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(username)
                .withClaim("role", role)
                .withClaim("username", username)
                .withClaim(key,  id+"")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRITION))
                .sign(algorithm);
    }

    public static Map<String, Claim> checkJWT(String token) throws JWTVerificationException{
            Algorithm algorithm = Algorithm.HMAC256(APP_SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build(); //Reusable verifier instance
            return verifier.verify(token).getClaims();

    }
    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static Integer getID(String token) {
        //doesn't verify
        return Integer.parseInt(JWT.decode(token).getClaim("merchantId").asString());
    }
    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
                //doesn't verify
        return JWT.decode(token).getClaim("username").asString();
    }
    public static Map<String, Claim> getAllClaim(String token) {
        //doesn't verify
        return JWT.decode(token).getClaims();
    }

    /**
     * 获取用户角色
     *
     * @param token
     * @return
     */
    public static String getUserRole(String token) {

        return JWT.decode(token).getClaim("role").asString();
    }

    /**
     * 是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return JWT.decode(token).getExpiresAt().before(new Date());
    }

    public static void main(String[] args) {
        String name = "a123321";
        String role = "role adim";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhMTIzMzIxIiwicm9sZSI6IlJPTEVfTUVSQ0hBTlQiLCJtZXJjaGFudElkIjoiMSIsImlzcyI6Imh1YW5nIiwiZXhwIjoxNTkxODU0OTk1LCJpYXQiOjE1OTEyNTAxOTUsInVzZXJuYW1lIjoiYTEyMzMyMSJ9.T1yyLiUMfEa_1piAIQG6Fc4xhQLb-OQXF7rzLqDi2wA\n";//createToken(name, "merchantId",123,role);
        System.out.println(token);

        Map<String, Claim> stringClaimMap = checkJWT(token);
        System.out.println(stringClaimMap);

        String token1 = createToken("a123321", "merchantId", 1, "role_merchant");
        checkJWT(token1);
        Map<String, Claim> allClaim = getAllClaim(token1);
        allClaim.entrySet().stream().forEach(e->{

            String key = e.getKey();
            String s = e.getValue().asString();

            System.out.println("####  ： "+  key+"  "+s);
        });

    }

}
