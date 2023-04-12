package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 
 * @author hariprasathv
 *
 */


/** 
 * BankApplication Class
 * */


@SpringBootApplication(scanBasePackages = {"com.example.model","com.example.demo","com.example.exception"})
@EnableJpaRepositories(basePackageClasses = com.example.model.BankDAO.class)
@EntityScan(basePackageClasses = com.example.model.BankDTO.class)
public class BankappApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}
}
