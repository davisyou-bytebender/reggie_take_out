package com.alibaba.reggie.controller;

import com.alibaba.reggie.common.Result;
import com.alibaba.reggie.entity.Employee;
import com.alibaba.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author davis you
 * @Date 2022/4/22 3:47 PM
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request,  @RequestBody Employee employee){
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());


        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        if(emp == null){
            return Result.error("登录失败");
        }

        if(!emp.getPassword().equals(password)){
            return Result.error("登录失败");
        }

        if(emp.getStatus() == 0){
            return Result.error("账号已禁用");
        }

        request.getSession().setAttribute("employee",emp.getId());
        return Result.success(emp);
    }


    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        // 清除session中保存的当前登录用户保存的id
        request.getSession().removeAttribute("employee");
        return Result.success("退出成功");

    }



}
