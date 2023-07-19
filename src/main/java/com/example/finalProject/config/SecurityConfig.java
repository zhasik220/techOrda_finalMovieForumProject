package com.example.finalProject.config;

import com.example.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserService userService(){
        return new UserService();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.exceptionHandling().accessDeniedPage("/403-page");

        AuthenticationManagerBuilder builder=http
                .getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userService())
                .passwordEncoder(passwordEncoder());

        http.formLogin().loginPage("/sign-in-page")
                .loginProcessingUrl("/auth") // <form action = "/to-enter" method = "post">
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .defaultSuccessUrl("/profile")
                .failureUrl("/sign-in-page?autherror");

        http.logout()
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/sign-in-page");

        http.csrf().disable();

        return http.build();
    }

}


