package com.lanou.hr.service.impl;


import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.service.DepartmentService;
import com.lanou.hr.util.PageBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    // 查询所有的部门
    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return departmentDao.findAll(hql);
    }

    // 分页查询部门
    @Override
    public PageBean<Department> findByPage(int pageNum, int pageSize) {
        String hql = "select count(*) from Department";
        String hql1 = "from Department where 1=1";
        int totalRecord = departmentDao.getTotalRecord(hql);
        PageBean<Department> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Department> data = departmentDao.findALL(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }





    @Override
    public void save(Department department) {
       departmentDao.save(department);
    }

    @Override
    public void update(Department department) {
         departmentDao.update(department);
    }

    @Override
    public Department findSingle(String hql, Map<String, Object> params) {
        return departmentDao.findSingle(hql,params);
    }

    @Override
    public Department get(Class<Department> departmentClass, Serializable id) {
        return departmentDao.get(departmentClass,id);
    }

    @Override
    public Department findById(String depId) {
        return departmentDao.findById(depId,Department.class);
    }




    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
