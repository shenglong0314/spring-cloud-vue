package com.glf.auth.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
           http.formLogin()
                   .permitAll()
                   .and()
               .authorizeRequests()
               .anyRequest()
               .authenticated();
    }


}
