package com.nr.job.feign.components;

import com.nr.job.feign.client.JobFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by yaleizhu on 2019/6/17.
 * description:
 */
@Component
@Slf4j
public class SchedualServiceHystric implements JobFeignClient {
    @Override
    public String test(String name) {

        log.info("something wrong!");
        return "对不起，您请求的服务出问题了" + name;
    }
}
