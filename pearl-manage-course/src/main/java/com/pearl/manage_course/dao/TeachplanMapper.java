package com.pearl.manage_course.dao;

import com.pearl.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 11:00
 */
@Mapper
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
