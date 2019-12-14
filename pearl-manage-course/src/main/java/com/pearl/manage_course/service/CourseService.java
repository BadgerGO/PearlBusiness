package com.pearl.manage_course.service;

import com.pearl.domain.course.CourseBase;
import com.pearl.domain.course.Teachplan;
import com.pearl.domain.course.ext.TeachplanNode;
import com.pearl.domain.course.response.AddCourseResult;
import com.pearl.exception.ExceptionCast;
import com.pearl.manage_course.dao.CourseBaseRepository;
import com.pearl.manage_course.dao.CourseMapper;
import com.pearl.manage_course.dao.TeachplanMapper;
import com.pearl.manage_course.dao.TeachplanRepository;
import com.pearl.model.response.CommonCode;
import com.pearl.model.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 10:56
 */
@Service
public class CourseService {
    @Autowired
    TeachplanMapper teachplanMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    TeachplanRepository teachplanRepository;


    //查询课程计划
    public TeachplanNode findTeachplanList(String courseId){
        TeachplanNode teachplanNode = teachplanMapper.selectList(courseId);
        return teachplanNode;
    }


    public CourseBase findCourseBaseById(String courseId){
        CourseBase courseBaseById = courseMapper.findCourseBaseById(courseId);
        return courseBaseById;
    }

    public ResponseResult addTeachplan(Teachplan teachplan) {
        //如果没有上传课程名字或者课程id，返回错误
        if (teachplan == null || StringUtils.isEmpty(teachplan.getPname()) ||
                StringUtils.isEmpty(teachplan.getCourseid())) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        String courseId = teachplan.getCourseid();
        String parentId = teachplan.getParentid();
        //如果parentId为空，这是根节点（章节点）
        if (StringUtils.isEmpty(parentId)){
            parentId = getTeachplantRoot(courseId);
        }
        //查询根结点信息
        Optional<Teachplan> optional = teachplanRepository.findById(parentId);
        Teachplan teachplan1 = optional.get();
        //父结点的级别
        String parent_grade = teachplan1.getGrade();
        //创建一个新结点准备添加
        Teachplan teachplanNew = new Teachplan();
        //将teachplan的属性拷贝到teachplanNew中
        BeanUtils.copyProperties(teachplan,teachplanNew);
        //要设置必要的属性
        teachplanNew.setParentid(parentId);
        if(parent_grade.equals("1")){
            teachplanNew.setGrade("2");
        }else{
            teachplanNew.setGrade("3");
        }
        teachplanNew.setStatus("0");//未发布
        teachplanRepository.save(teachplanNew);
        return new ResponseResult(CommonCode.SUCCESS);

    }

    private String getTeachplantRoot(String courseId) {
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if(!optional.isPresent()){
            return null;
        }
        CourseBase courseBase = optional.get();
        //调用dao查询teachplan表得到该课程的根结点（一级结点）
        List<Teachplan> teachplanList = teachplanRepository.findByCourseidAndParentid(courseId, "0");
        if(teachplanList == null || teachplanList.size()<=0){
            //新添加一个课程的根结点
            Teachplan teachplan = new Teachplan();
            teachplan.setCourseid(courseId);
            teachplan.setParentid("0");
            teachplan.setGrade("1");//一级结点
            teachplan.setStatus("0");
            teachplan.setPname(courseBase.getName());
            teachplanRepository.save(teachplan);
            return teachplan.getId();

        }
        //返回根结点的id
        return teachplanList.get(0).getId();
    }

    /***
    * @author: YaBing
    * @description: 新增课程
    * @date  2019/12/13 20:57
    * @return {@link AddCourseResult}
     * @param courseBase
    */
    @Transactional
    public AddCourseResult addCourseBase(CourseBase courseBase){
        //课程状态默认为未发布
        courseBase.setStatus("202001");
        courseBaseRepository.save(courseBase);
        return new AddCourseResult(CommonCode.SUCCESS,courseBase.getId());
    }

    /***
    * @author: YaBing
    * @description: 根据课程id显示课程的基本信息
    * @date  2019/12/14 9:00
    * @return {@link CourseBase}
     * @param courseId
    */
    public CourseBase getCourseBaseById(String courseId){
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /***
    * @author: YaBing
    * @description: 更新课程基本信息
    * @date  2019/12/14 9:15
    * @return {@link ResponseResult}
     * @param courseId
     * @param courseBase
    */
    public ResponseResult updateCourseBase(String courseId,CourseBase courseBase){
        CourseBase oldCourseBase = this.getCourseBaseById(courseId);

        if (oldCourseBase == null){
//            return new ResponseResult(CommonCode.FAIL);
        }
        //修改课程信息
        oldCourseBase.setName(courseBase.getName());
        oldCourseBase.setMt(courseBase.getMt());
        oldCourseBase.setSt(courseBase.getSt());
        oldCourseBase.setGrade(courseBase.getGrade());
        oldCourseBase.setUsers(courseBase.getUsers());
        oldCourseBase.setDescription(courseBase.getDescription());
        CourseBase save = courseBaseRepository.save(oldCourseBase);
        return new ResponseResult(CommonCode.SUCCESS);
    }


}
