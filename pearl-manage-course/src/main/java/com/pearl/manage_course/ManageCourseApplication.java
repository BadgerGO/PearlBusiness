package com.pearl.manage_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 10:34
 */
@SpringBootApplication
@EntityScan("com.pearl.domain.course")//扫描实体类
@ComponentScan(basePackages={"com.pearl.api"})//扫描接口
@ComponentScan(basePackages={"com.pearl.manage_course"})
@ComponentScan(basePackages={"com.pearl"})//扫描common下的所有类
public class ManageCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCourseApplication.class,args);
    }
}

