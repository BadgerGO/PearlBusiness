package com.pearl.manage_course.controller;

import com.pearl.api.course.SysDictionaryControllerApi;
import com.pearl.domain.system.SysDictionary;
import com.pearl.manage_course.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/13 0013 20:32
 */
@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController implements SysDictionaryControllerApi {
    @Autowired
    SysDictionaryService sysDictionaryService;

    @Override
    @GetMapping("/{type}")
    public SysDictionary getByType(@PathVariable("type") String type) {
        return sysDictionaryService.findSysDictionaryBydType(type);
    }
}
