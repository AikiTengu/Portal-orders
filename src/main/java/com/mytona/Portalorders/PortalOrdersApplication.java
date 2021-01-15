package com.mytona.Portalorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PortalOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalOrdersApplication.class, args);
	}

}
