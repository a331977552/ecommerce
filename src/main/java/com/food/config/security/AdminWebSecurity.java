package com.food.config.security;

import com.food.filter.JWTAdminAuthenticationFilter;
import com.food.filter.JWTAdminAuthorizationFilter;
import com.food.service.IMerchantService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@PropertySource("classpath:bootstrap.properties")
@Order(100)
public class AdminWebSecurity extends WebSecurityConfigurerAdapter {

    final IMerchantService service;
    @Value("${admin.login.url}")
    String adminLoginUrl;



    public AdminWebSecurity(IMerchantService service) {
        this.service = service;
    }

    public PasswordEncoder getPasswordEncoder(){
     return new BCryptPasswordEncoder(11);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(service).passwordEncoder(getPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests().antMatchers(
                "/api/product/add/**",
                "/api/product/update/**",
                "/api/product/delete/**",
                "/api/cate/add/**",
                "/api/cate/update/**",
                "/api/cate/delete/**",
                "/api/img/add/**",
                "/api/merchant",
                "/api/shop/**",
                "/api/order/findAllOrdersByMerchant/**"
                ).hasAnyRole("MERCHANT","ADMIN").antMatchers("/auth/manage/merchantManagement").hasRole("ADMIN")
                // 其他都放行了
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTAdminAuthenticationFilter(authenticationManager(),adminLoginUrl))
                .addFilter(new JWTAdminAuthorizationFilter(authenticationManager(),new CustomHttp403ForbiddenEntryPoint()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling();//.accessDeniedHandler(new CustomAccessDeniedHandler())
//                .authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint());
    }




}
