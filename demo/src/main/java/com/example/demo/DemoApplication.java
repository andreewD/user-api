package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(DemoApplication.class, args);
	}

}
