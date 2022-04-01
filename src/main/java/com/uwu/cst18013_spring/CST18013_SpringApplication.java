package com.uwu.cst18013_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.uwu.cst18013_spring") 
public class CST18013_SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CST18013_SpringApplication.class, args);
	}

}
