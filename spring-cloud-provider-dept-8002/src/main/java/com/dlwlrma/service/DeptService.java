package com.dlwlrma.service;

import com.dlwlrma.pojo.Dept;

import java.util.List;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 19:02
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
