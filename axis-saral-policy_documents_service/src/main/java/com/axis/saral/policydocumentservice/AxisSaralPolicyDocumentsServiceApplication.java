	package com.axis.saral.policydocumentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableWebMvc
@SpringBootApplication
@EnableEurekaClient
public class AxisSaralPolicyDocumentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxisSaralPolicyDocumentsServiceApplication.class, args);
	}
}
