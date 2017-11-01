package com.lanou.teach.service;


import com.lanou.teach.domain.CourseType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public interface CourseService {
    // 查询所有
    List<CourseType> findAll();

    // 查询一个对象
    CourseType get(Class<CourseType> c, Serializable id);

    // 保存一个对象
    void save(CourseType courseType);

    // 更新一个对象
    void update(CourseType courseType);
}
