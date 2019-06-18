package com.nr.job.eureka.client.controller;

import com.nr.job.eureka.client.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by yaleizhu on 2019/5/28.
 * description:
 */
@RestController
@RequestMapping("/cal")
public class CalculatorController {


    @Autowired
    CalculatorService calculatorService;

    @Value("${value}")
    String aaa;


    @GetMapping
    public BigDecimal add(String  a, String  b) {
        System.out.println("-----------" + aaa);

        return calculatorService.add(new BigDecimal(a), new BigDecimal(b));

    }

}
