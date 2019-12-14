package com.pearl.manage_course.service;

import com.pearl.domain.course.ext.CategoryNode;
import com.pearl.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/11 0011 11:03
 */
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryNode findCategoryList(){
        return categoryMapper.selectList();
    }

}
