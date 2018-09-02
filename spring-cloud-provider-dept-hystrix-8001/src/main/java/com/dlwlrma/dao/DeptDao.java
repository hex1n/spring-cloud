package com.dlwlrma.dao;

import com.dlwlrma.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 18:56
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
