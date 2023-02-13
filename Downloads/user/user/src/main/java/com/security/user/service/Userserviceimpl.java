package com.security.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.user.model.User;
import com.security.user.repo.Userrepo;
@Component
public class Userserviceimpl implements UserDetailsService{
	@Autowired
	Userrepo userrepo;

	Logger log = LoggerFactory.getLogger(Userserviceimpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("Enter into the userdetails class with loadbyusername method exists");
		 
		//User student =  userrepo.getById(username);
		List<User> data = userrepo.getStudents(username);
		
		log.info("got data from DB with id and size is :"+data.size());
		
		

		if(data.size() >  0) {
			MyUserDetails ob =  new MyUserDetails(data.get(0));
			log.info("Sending the data to MyUserDetails class with username :"+data.get(0).getUsername());
			 
			log.info(" Object : "+ob.getUsername());
		
			return new MyUserDetails(data.get(0));
		}
	    throw new UsernameNotFoundException(username+ " Not FOund");
	}

}
