package com.axis.saral.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AxisSaralEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxisSaralEurekaServerApplication.class, args);
	}

}
