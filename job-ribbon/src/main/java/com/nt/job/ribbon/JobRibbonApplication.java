package com.nt.job.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class JobRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobRibbonApplication.class, args);
	}

	@Bean
    @LoadBalanced
	RestTemplate getTemplate() {
	    return new RestTemplate();
    }
}
