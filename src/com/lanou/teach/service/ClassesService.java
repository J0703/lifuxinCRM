package com.lanou.teach.service;

import com.lanou.teach.domain.Classes;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/31.
 */
public interface ClassesService {

    // 查询所有班级
    List<Class> findAll();

    Classes findSingle(Class<Classes> classClass,String classId);

    void update(Classes classes);

    void save(Classes classes);


    List<Classes> findByCourse(Map<String,Object> params);


}
