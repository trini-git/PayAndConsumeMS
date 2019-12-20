package com.payandconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PayAndConsumeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayAndConsumeMsApplication.class, args);
	}

}
