package com.dlwlrma.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: hex1n
 * @Date: 2018/8/26 11:01
 */


//@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    /**
     * 主键
     */
    private Long deptno;
    /**
     *  部门名称
     */
    private String dname;
    /**
     *     来自哪个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同数据库
     */
    private String db_source;


    public Dept(String dname) {
        super();
        this.dname = dname;
    }

}
