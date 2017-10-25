package com.lanou.hr.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface BaseDao<T> {

    // 查询所有的部门
    List<T> findAll(String hql);

    // 添加部门
    T save(T t);

    // 更新部门
    T update(T t);

    // 条件查询
    T findSingle(String hql, Map<String,Object> params);

    // 通过id获得
    T get(Class<T> c, Serializable id);




}
