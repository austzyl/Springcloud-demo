package com.nt.job.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yaleizhu on 2019/4/3.
 * description:
 */
@RestController
@Slf4j
public class JobRibbonClient {

    @Autowired
    RestTemplate template;

    @Value("${server.port}")
    String port;

    @RequestMapping("/job/getTest")
    @HystrixCommand(fallbackMethod="getTestByRibbonFallback")
    public String getTest() {
        return this.template.getForObject("http://service-eureka-client/test", String.class);
    }

    public String getTestByRibbonFallback() {
        log.error("服务器错误：" + port);
        return port;
    }
}
