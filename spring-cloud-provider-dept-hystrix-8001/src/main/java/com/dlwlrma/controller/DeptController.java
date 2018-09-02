package com.dlwlrma.controller;

import com.dlwlrma.pojo.Dept;
import com.dlwlrma.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 19:07
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService = null;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {

        return deptService.add(dept);
    }


    /**
     * @param id
     * @return 一旦调用服务方法失败并抛出了错误信息后, 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     */
    @HystrixCommand(fallbackMethod = "procdessHystrix_Get")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {

        Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID:" + id + "没有对应信息");
        }

        return dept;
    }

    public Dept procdessHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID:" + id + "没有对应信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {

        return deptService.list();
    }

    /**
     * 服务发现
     */
    @GetMapping(value = "/dept/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("....." + list);
        List<ServiceInstance> srvList = client.getInstances("SPRING-CLOUD-DEPT");
        for (ServiceInstance instance : srvList) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() +
                    "\t" + instance.getPort() + "\t" + instance.getUri()
            );
        }
        return this.client;
    }
}
