/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author соколов
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // System.out.println(customUserDetailsService.loadUserByUsername("alex").toString());
        auth.userDetailsService(customUserDetailsService);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/vc").permitAll()
                .antMatchers("/bron","/client","/dolgnost","/home","/orders","/sotrudnik","/organiz","/typezav","/typenomerhot","/tarif","/uslug","/programs","/pitan","/typeuser","/dolgnost","/stoimostpitan","/stoimostnomer","/stoimostuslug","/otpusk","/grafik","/client","/bronz","/nomer","/reestuslug","/progiv").hasAnyRole("ADMIN","ZAM","DIRECTOR")        
                        
                
                .and();

        http.formLogin()
                // ????????? ???????? ? ?????? ??????
                .loginPage("/enter")
                // ????????? action ? ????? ??????
                .loginProcessingUrl("/j_spring_security_check")
                // ????????? URL ??? ????????? ??????
                .failureUrl("/enter?error")
                // ????????? ????????? ?????? ? ?????? ? ????? ??????
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/index", true)
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // ????????? ?????? ?????? ????
                .permitAll()
                // ????????? URL ???????
                .logoutUrl("/logout")
                // ????????? URL ??? ??????? ???????
                .logoutSuccessUrl("/")
                // ?????? ?? ???????? ??????? ??????
                .invalidateHttpSession(true);
    }

}
