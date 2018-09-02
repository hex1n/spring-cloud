package com.dlwlrma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 21:17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.dlwlrma")
@ComponentScan("com.dlwlrma")
public class ConsumerApplicationFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationFeign80.class, args);
    }
}
