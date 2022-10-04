package com.server.userservice.security;


import com.server.userservice.service.UserService;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;
import javax.servlet.annotation.ServletSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Environment env;

    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, Environment env) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll();
        http.authorizeRequests().antMatchers("/actuator/**").permitAll();
        http.authorizeRequests().antMatchers("/health_check/**").permitAll();
        http.authorizeRequests().antMatchers("/**").permitAll();
//                .hasIpAddress(env.getProperty("192.168.0.6")) // <- IP 변경
//                .and()
//                .addFilter(getAuthenticationFilter());

        http.headers().frameOptions().disable();
    }
    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter =
                new AuthenticationFilter(authenticationManager(), userService, env);

        return authenticationFilter;
    }

    // select pwd from users where email=?
    // db_pwd(encrypted) == input_pwd(encrypted)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


}
