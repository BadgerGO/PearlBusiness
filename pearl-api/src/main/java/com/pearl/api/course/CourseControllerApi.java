package com.pearl.api.course;

import com.pearl.domain.course.CourseBase;
import com.pearl.domain.course.Teachplan;
import com.pearl.domain.course.ext.TeachplanNode;
import com.pearl.domain.course.response.AddCourseResult;
import com.pearl.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 10:40
 */
@Api(value="课程管理接口",description = "课程管理接口，提供课程的增、删、改、查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    public AddCourseResult addCourseBase(CourseBase courseBase);

    public CourseBase findCourseBaseById(String courseId) throws RuntimeException;

    public ResponseResult updateCoursebase(String courseId,CourseBase courseBase);

}
