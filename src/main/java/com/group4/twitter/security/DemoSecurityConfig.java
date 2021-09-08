package com.group4.twitter.security;

import com.group4.twitter.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoService userService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder getPassEncoded() {
//		return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/home").hasAuthority("USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

}
