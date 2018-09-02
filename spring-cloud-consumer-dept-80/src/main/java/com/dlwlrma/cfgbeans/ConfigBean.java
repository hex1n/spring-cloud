package com.dlwlrma.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 20:42
 */

@Configuration
public class ConfigBean //boot --->spring    applicationContext.xml ---- @Configuration配置  ConfigBean = applicationContext.xml
{

    @Bean
    /**
     *  ribbon 客户端负载均衡
     */
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRules() {

        //随机算法
//        return new RandomRule();

        return  new RetryRule();
    }

}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id ="userService" class>
