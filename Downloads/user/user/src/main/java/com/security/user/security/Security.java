package com.security.user.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.security.user.service.Userserviceimpl;
@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableWebMvc
@Component
@Configuration
public class Security {
	
	@Autowired
	Userserviceimpl userserviceimpl;
	
	Logger log = LoggerFactory.getLogger(Security.class);
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests()
			.requestMatchers("/data", "/login")
			.permitAll()
			.anyRequest().authenticated();
			
		
		//http.authorizeHttpRequests().anyRequest().authenticated();
//		    .requestMatchers("/student/*").authenticated()
//		    .and()
//		    .authorizeHttpRequests()
//		          .requestMatchers("/*")
//		    .permitAll();
//		    .and().authorizeHttpRequests().requestMatchers("/add/*").permitAll();
		   
		  
		    
		    //.requestMatchers( "/user").permitAll()
		    
		    
		
		return http.build();
		

	}
	


	@Primary
	@Bean
	public AuthenticationManagerBuilder authenticationManagerBuilder1(AuthenticationManagerBuilder a) {
		return a.authenticationProvider(daoAuthenticationProvider()) ;
		
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
//	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider obj = new DaoAuthenticationProvider();
		//userserviceimpl.loadUserByUsername(upat.getName());
		log.info("Entering to Provider");
		obj.setUserDetailsService(userserviceimpl);
		obj.setPasswordEncoder(passwordEncoder());
		
		return obj;
		
	}
	
	

}
