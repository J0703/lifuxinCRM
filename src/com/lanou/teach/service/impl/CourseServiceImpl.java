package com.lanou.teach.service.impl;

import com.lanou.teach.dao.CourseDao;
import com.lanou.teach.domain.CourseType;
import com.lanou.teach.service.CourseService;

import java.io.Serializable;
import java.util.List;


/**
 * Created by dllo on 17/10/31.
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    // 查询所有返回一个集合
    @Override
    public List<CourseType> findAll() {
        String hql = "from CourseType";
        return courseDao.findAll(hql);
    }
    // 通过id查询一个对象
    @Override
    public CourseType get(Class<CourseType> c, Serializable id) {
        return courseDao.get(c, id);
    }

    @Override
    public void save(CourseType courseType) {
        courseDao.save(courseType);
    }

    // 更新一个对象
    @Override
    public void update(CourseType courseType) {
        courseDao.update(courseType);
    }


    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
