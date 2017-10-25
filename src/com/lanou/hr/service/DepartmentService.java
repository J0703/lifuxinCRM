package com.lanou.hr.service;

import com.lanou.hr.domain.Department;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {
    List<Department> findAll();

    Department save(Department department);

    Department update(Department department);

    Department findSingle(String hql, Map<String,Object> params);

    Department get(Class<Department> departmentClass,Serializable id);

}
