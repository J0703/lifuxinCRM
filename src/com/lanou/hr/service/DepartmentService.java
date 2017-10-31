package com.lanou.hr.service;

import com.lanou.hr.domain.Department;
import com.lanou.hr.util.PageBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {
    List<Department> findAll();

    void  save(Department department);

    void update(Department department);

    Department findSingle(String hql, Map<String,Object> params);

    Department get(Class<Department> departmentClass,Serializable id);

    Department findById(String depId);

    // 分页查询部门
    PageBean<Department> findByPage(int pageNum,int pageSize);
}
