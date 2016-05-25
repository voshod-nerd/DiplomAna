package com.infiniteskills.mvc.config;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
     
    @Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        http.csrf()
                .disable()
                // ��������� ������� ��������
                // �� ������� ����� ����������� ������ � �������� � ��������� ������
                .authorizeRequests()
                .antMatchers("/resources/**", "/vc","/").permitAll()
                .antMatchers("/home").hasRole("ROLE_ADMIN")
                
                .and();
 
        http.formLogin()
                // ��������� �������� � ������ ������
                .loginPage("/enter")
                // ��������� action � ����� ������
                .loginProcessingUrl("/j_spring_security_check")
                // ��������� URL ��� ��������� ������
                .failureUrl("/enter?error")
                // ��������� ��������� ������ � ������ � ����� ������
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                
                // ���� ������ � ����� ������ ����
                .permitAll();
 
        http.logout()
                // ��������� ������ ������ ����
                .permitAll()
                // ��������� URL �������
                .logoutUrl("/logout")
                // ��������� URL ��� ������� �������
                .logoutSuccessUrl("/")
                // ������ �� �������� ������� ������
                .invalidateHttpSession(true);
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}