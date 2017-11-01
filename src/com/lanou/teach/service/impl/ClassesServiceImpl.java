package com.lanou.teach.service.impl;

import com.lanou.teach.dao.ClassesDao;
import com.lanou.teach.domain.Classes;
import com.lanou.teach.service.ClassesService;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/31.
 */
public class ClassesServiceImpl implements ClassesService {

    private ClassesDao classesDao;
    private Classes classes;

    // 查询班级
    @Override
    public List<Class> findAll() {
        String hql = "from Classes";
        return classesDao.findAll(hql);
    }

    @Override
    public Classes findSingle(Class<Classes> classClass, String classId) {
        return null;
    }

    @Override
    public void update(Classes classes) {

    }

    @Override
    public void save(Classes classes) {

    }

    @Override
    public List<Classes> findByCourse(Map<String, Object> params) {
        return null;
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
