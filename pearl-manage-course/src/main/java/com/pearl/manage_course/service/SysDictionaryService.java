package com.pearl.manage_course.service;

import com.pearl.domain.system.SysDictionary;
import com.pearl.manage_course.dao.SysDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/13 0013 20:30
 */
@Service
public class SysDictionaryService {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;

    public SysDictionary findSysDictionaryBydType(String dType){
        return sysDictionaryRepository.findBydType(dType);
    }


}
