package com.ek.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
private DataSource securityDataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource);

//        User.UserBuilder  users = User.withDefaultPasswordEncoder();
////
////        auth.inMemoryAuthentication()
////                .withUser(users.username("emre").password("1234").roles("employee"))
////                .withUser(users.username("emremanager").password("1234").roles("employee","manager"))
////                .withUser(users.username("emreadmin").password("1234").roles("employee","admin"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }
}
