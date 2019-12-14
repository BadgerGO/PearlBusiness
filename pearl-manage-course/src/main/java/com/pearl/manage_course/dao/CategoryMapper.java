package com.pearl.manage_course.dao;

import com.pearl.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/11 0011 9:59
 */
@Mapper
public interface CategoryMapper {
    public CategoryNode selectList();
}
