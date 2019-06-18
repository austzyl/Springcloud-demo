package com.nr.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class JobRedisSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobRedisSessionApplication.class, args);
	}

}
