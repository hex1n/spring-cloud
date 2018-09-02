package com.ruleconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: hex1n
 * @Date: 2018/8/27 22:56
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {

        //默认为轮询,自定义为随机
        return new RandomRule_HX();
    }
}
