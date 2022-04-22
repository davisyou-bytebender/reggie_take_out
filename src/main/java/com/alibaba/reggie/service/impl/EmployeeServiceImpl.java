package com.alibaba.reggie.service.impl;

import com.alibaba.reggie.entity.Employee;
import com.alibaba.reggie.mapper.EmployeeMapper;
import com.alibaba.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author davis you
 * @Date 2022/4/22 3:46 PM
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
