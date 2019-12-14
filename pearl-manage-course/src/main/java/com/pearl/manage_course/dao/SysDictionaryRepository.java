package com.pearl.manage_course.dao;

import com.pearl.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/13 0013 20:27
 */
@Repository
public interface SysDictionaryRepository extends MongoRepository<SysDictionary,String> {
    SysDictionary findBydType(String dType);
}
