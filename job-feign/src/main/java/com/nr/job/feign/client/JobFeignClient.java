package com.nr.job.feign.client;

import com.nr.job.feign.components.SchedualServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaleizhu on 2019/4/3.
 * description:
 */
@FeignClient(name="service-eureka-client",fallback = SchedualServiceHystric.class)
public interface JobFeignClient {

    @RequestMapping("test")
    String test(@RequestParam("name") String name);
}

