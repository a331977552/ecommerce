//package com.food.food.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
////@EnableWebSecurity()
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//     return new BCryptPasswordEncoder(11);
//    }
//    /*
//    @Autowired
//    ManagerDetailService userdetailService;*/
//    @Override
//    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
//	/*	web
//		.ignoring().
//				antMatchers("/static/**").
//				antMatchers("/error/*");
//      */ web.ignoring().antMatchers("/**");
//    }
//
//
///*
//    @Autowired
//    MyAuthenticationProvider authenticationprovider;*/
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//   auth.inMemoryAuthentication()
//                .withUser("admin").password(getPasswordEncoder().encode("adminPass")).roles("ADMIN")
//                .and()
//                .withUser("user").password(getPasswordEncoder().encode("userPass")).roles("USER");
//    }
//
//
//@Autowired
//RestAuthenticationEntryPoint entryPoint;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//         /*       http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(entryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/foos").authenticated()
//                .antMatchers("/api/**").hasRole("USER")
//                .and()
//                .formLogin().usernameParameter("email")
//                        .passwordParameter("password")
//                .successHandler(new MySavedRequestAwareAuthenticationSuccessHandler())
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout();*/
//
//        http.authorizeRequests().antMatchers("/**").permitAll();
//      /* http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/error*").permitAll().
//                antMatchers("/**").hasRole("ADMIN").and().formLogin().loginPage("/login").successHandler(new SimpleLoginSuccessHandler()).failureHandler(new LoginFailureHandler())
//                .permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true);*/
//    }
//
//
//
//
//}
