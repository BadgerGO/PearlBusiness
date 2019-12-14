package com.pearl.manage_course.dao;

import com.pearl.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YaBing 508705569@qq.com
 * @version 1.0
 * @description: TODO
 * @date 2019/12/8 0008 19:40
 */
public interface TeachplanRepository extends JpaRepository<Teachplan,String> {
    List<Teachplan> findByCourseidAndParentid(String couseId,String parentId);
}
