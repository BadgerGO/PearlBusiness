package com.pearl.mansge_course.dao;

import com.pearl.domain.course.CourseBase;
import com.pearl.manage_course.dao.CourseMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 11:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Testdao {
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testCourseMapper(){
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }
}
