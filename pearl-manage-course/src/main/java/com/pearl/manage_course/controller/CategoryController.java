package com.pearl.manage_course.controller;

import com.pearl.api.course.CategoryControllerApi;
import com.pearl.domain.course.ext.CategoryNode;
import com.pearl.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/11 0011 11:06
 */
@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    @Override
    public CategoryNode findCategoryList(){
        return categoryService.findCategoryList();
    }
}
