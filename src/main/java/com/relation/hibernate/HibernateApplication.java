package com.relation.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.relation.hibernate.service.Marksservice;
import com.relation.hibernate.service.Studentclassservice;
import com.relation.hibernate.service.Studentservice;

@SpringBootApplication
@EnableJpaRepositories

public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}
	@Bean
	public static Marksservice ms() {
		return new Marksservice();
	}
	
	@Bean
	public static Studentclassservice scs() {
		return new Studentclassservice();
	}
	
	@Bean
	public static Studentservice ss() {
		return new Studentservice();
	}

}
