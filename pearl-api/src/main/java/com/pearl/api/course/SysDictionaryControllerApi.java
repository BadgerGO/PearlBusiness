package com.pearl.api.course;

import com.pearl.domain.system.SysDictionary;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: 查询课程等级接口，高、中、低级
 * @date 2019/12/13 0013 20:21
 */
public interface SysDictionaryControllerApi {
    public SysDictionary getByType(String type);
}
