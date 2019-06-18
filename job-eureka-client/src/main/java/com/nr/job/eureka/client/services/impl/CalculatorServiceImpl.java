package com.nr.job.eureka.client.services.impl;

import com.nr.job.eureka.client.services.CalculatorService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by yaleizhu on 2019/5/28.
 * description:
 */
@Service("calculatorService")
@Scope("prototype")
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
