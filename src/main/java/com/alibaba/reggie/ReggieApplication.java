package com.alibaba.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author davis you
 * @Date 2022/4/22 3:04 PM
 * @Version 1.0
 */

// 注解slf4j 就能使用log这个变量了
@Slf4j
@SpringBootApplication
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class,args);
        log.info("项目启动成功");

    }
}
