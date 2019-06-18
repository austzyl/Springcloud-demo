package com.nr.job.eureka.client;

import com.nr.job.eureka.client.entities.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
@EnableEurekaClient
@Slf4j
public class JobEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobEurekaClientApplication.class, args);
	}

    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        log.info("--------------------------------------------test----------------------------------");
        Job job = new Job();
        job.setJobName("a");
        /*if (true) {
            throw new NullPointerException("");
        }*/
        log.info("name" + request.getParameter("name"));

        return job.toString() + ",port:" + request.getServerPort() + ",name:" + request.getParameter("name");
    }

}
