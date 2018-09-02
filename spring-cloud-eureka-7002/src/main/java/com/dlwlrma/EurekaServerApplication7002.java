package com.dlwlrma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: hex1n
 * @Date: 2018/8/27 13:02
 */

//EurekaServer服务端启动类,接受其他微服务注册进来
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7002.class, args);
    }
}
