package com.nr.job.feign.api;

import com.nr.job.feign.client.JobFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaleizhu on 2019/4/3.
 * description:
 */
@RestController
public class JobFeignApi {

    @Autowired
    JobFeignClient feignClient;

    @GetMapping("getTest/{name}")
    public String getTest(@PathVariable  String name) {
        return this.feignClient.test(name);
    }
}

