package com.nr.job.eureka.client1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class JobEurekaClient1Application {

    public static void main(String[] args) {

        SpringApplication.run(JobEurekaClient1Application.class, args);
    }

    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        log.info("name:" + request.getParameter("name"));

        return "port:" + request.getServerPort() + ",name:" + request.getParameter("name");
    }

}
