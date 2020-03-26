package com.pedrovsn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BytebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BytebankApplication.class, args);
	}

}
