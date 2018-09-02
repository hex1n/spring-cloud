package com.dlwlrma.controller;

import com.dlwlrma.pojo.Dept;
import com.dlwlrma.service.DeptService;
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
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {

        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
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
