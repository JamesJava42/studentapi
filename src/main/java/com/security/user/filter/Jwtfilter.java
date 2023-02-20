package com.security.user.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.user.service.Jwtservice;
import com.security.user.service.Userserviceimpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Jwtfilter extends OncePerRequestFilter {

	
	@Autowired
	Jwtservice jwtservice;
	@Autowired
	Userserviceimpl userserviceimpl;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=null;
		//String token = null;
		String jwttoken="";
		String token = request.getHeader("AUTHORIZATION");
		//token = tok.substring(7);
		System.out.println(token);
		
		if(token != null ) {
			jwttoken = token.substring(7);
			
			username = jwtservice.extractUsername(jwttoken);
			System.out.println(jwttoken+" username "+username);
			//SecurityContextHolder.getContext().setAuthentication(null);
		}
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails user = userserviceimpl.loadUserByUsername(username);
			System.out.println("Inside userdetails object"+user);
			if(jwtservice.validateToken(jwttoken, user));
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null,null);
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
		
		
		
	}

}
