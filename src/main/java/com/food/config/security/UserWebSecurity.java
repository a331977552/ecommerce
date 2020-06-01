package com.food.config.security;

import com.food.filter.JWTUserAuthenticationFilter;
import com.food.filter.JWTUserAuthorizationFilter;
import com.food.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Order(101)
public class UserWebSecurity extends WebSecurityConfigurerAdapter {


    public PasswordEncoder getPasswordEncoder(){
     return new BCryptPasswordEncoder(11);
    }

    @Value("${user.login.url}") String userLoginUrl;

    @Autowired
    private ICustomerService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests().antMatchers(
                        "/customer/update/**"
                ).hasRole("USER")
                // 其他都放行了
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTUserAuthenticationFilter(authenticationManager(),userLoginUrl))
                .addFilter(new JWTUserAuthorizationFilter(authenticationManager()))
                // 不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint());

    }




}
