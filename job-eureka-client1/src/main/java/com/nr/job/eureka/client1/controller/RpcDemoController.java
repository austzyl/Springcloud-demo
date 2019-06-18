package com.nr.job.eureka.client1.controller;

import com.nr.job.eureka.client1.RpcService.RpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by yaleizhu on 2019/5/28.
 * description:
 */
@RestController
@RequestMapping("rpc")
public class RpcDemoController {
    @Autowired
    RpcServiceImpl rpcService;


    @GetMapping
    public BigDecimal getDecimal(String a, String b) throws IOException {

       return rpcService.getAddResult(a, b);

    }

}
