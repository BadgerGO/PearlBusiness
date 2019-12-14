package com.pearl.manage_course.controller;

import com.pearl.api.course.CourseControllerApi;
import com.pearl.domain.course.CourseBase;
import com.pearl.domain.course.Teachplan;
import com.pearl.domain.course.ext.TeachplanNode;
import com.pearl.domain.course.response.AddCourseResult;
import com.pearl.manage_course.service.CourseService;
import com.pearl.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 10:56
 */
@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {

    @Autowired
    CourseService courseService;

    /**
    * @author: YaBing
    * @description: 课程计划查询列表
    * @date  2019/12/08 19:15
    * @return {@link TeachplanNode}
     * @param courseId
    */
    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }

    @Override
    @PostMapping("/coursebase/add")
    public AddCourseResult addCourseBase(CourseBase courseBase) {
        return courseService.addCourseBase(courseBase);
    }

    @Override
    @GetMapping("/coursebase/get/{courseId}")
    public CourseBase findCourseBaseById(@PathVariable("courseId") String courseId) throws RuntimeException {
        return courseService.getCourseBaseById(courseId);
    }

    /***
    * @author: YaBing
    * @description: 测试加@RequestBody注解报错
    * @date  2019/12/14 9:48
    * @return {@link ResponseResult}
     * @param courseId
     * @param courseBase
    */
    @Override
    @PutMapping("/coursebase/update/{courseId}")
    public ResponseResult updateCoursebase(@PathVariable("courseId") String courseId,CourseBase courseBase) {
        return courseService.updateCourseBase(courseId,courseBase);
    }


}
