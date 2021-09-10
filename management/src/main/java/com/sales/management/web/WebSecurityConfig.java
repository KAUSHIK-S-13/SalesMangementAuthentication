package com.sales.management.web;

import com.sales.management.ServiceImpl.OrderServiceImpl;
import com.sales.management.ServiceImpl.SparepartsServiceImpl;
import com.sales.management.ServiceImpl.SparepartstypeServiceImpl;
import com.sales.management.ServiceImpl.UserServiceImpl;
import com.sales.management.security.JwtAuthenticationEntryPoint;
import com.sales.management.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserServiceImpl userServiceimpl;

    @Autowired
    private SparepartsServiceImpl sparepartsserviceimpl;

    @Autowired
    private SparepartstypeServiceImpl sparpartstypeserviceimpl;

    @Autowired
    private OrderServiceImpl orderserviceimpl;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors();
        http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        http.authorizeRequests()
                .antMatchers("/user/add","/user/login")
                .permitAll().anyRequest().authenticated().and().formLogin().permitAll();

        http.addFilterBefore(jwtFilter(),UsernamePasswordAuthenticationFilter.class);


    }
}