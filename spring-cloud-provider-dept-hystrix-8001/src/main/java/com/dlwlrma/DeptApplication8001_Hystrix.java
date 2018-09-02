package com.dlwlrma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 19:45
 */
@SpringBootApplication
//本服务启动后自动注册eureka服务中
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
//对hystrix熔断机制的支持
@EnableCircuitBreaker
public class DeptApplication8001_Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication8001_Hystrix.class, args);
    }
}
