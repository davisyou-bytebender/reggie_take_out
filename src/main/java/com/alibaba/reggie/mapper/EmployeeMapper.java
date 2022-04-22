package com.alibaba.reggie.mapper;

import com.alibaba.reggie.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author davis you
 * @Date 2022/4/22 3:44 PM
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
