package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.AccountsDAO;
import com.model.AccountsDTO;
import com.model.BankingService;
import com.model.InsufficientBalance;
import com.model.Myservice;
import com.model.TransactionService;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})

public class DemoApp {
	public static void main(String[] args) throws InsufficientBalance {
    	ConfigurableApplicationContext ctx = SpringApplication.run(DemoApp.class, args);
	
    	TransactionService ts = ctx.getBean("tss",TransactionService.class);
    	ts.moneyTransfer(100, 200, 2000);
    	
    }
}
