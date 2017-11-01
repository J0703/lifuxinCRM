package com.lanou.hr.dao;

import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;

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
    void save(T t);

    // 更新部门
    void update(T t);

    // 条件查询
    T findSingle(String hql, Map<String,Object> params);

    // 通过id获得
    T get(Class<T> c, Serializable id);

    // 通过id查询
    T findById(Serializable id,Class<T> tClass);

    // 查询返回集合
    List<T> find(String hql, Map<String, Object> params);

    List<T> find(String hql,Object[] params);

    // 分页
    int getTotalRecord(String hql);

    // 分页时的查询所有
    List<T> findALL(String hql,int startIndex,int pageSize);

}
