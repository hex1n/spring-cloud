package com.dlwlrma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 19:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication8001.class, args);
    }
}
