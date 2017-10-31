package com.lanou.hr.service;


import com.lanou.hr.domain.Staff;
import com.lanou.hr.util.PageBean;
import sun.jvm.hotspot.debugger.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public interface StaffService {
    // 查询显示所有员工
    List<Staff> findAll();

    // 根据id查询某个对象
    Staff get(Class<Staff> c,Serializable id);

    // 添加员工
    void add(Staff staff);

    // 更新员工
    void update(Staff staff);

    // 根据查询条件进行模糊查询
    List<Staff> findStaff(Staff staff, String depID,String postId);

    // 查询分页
    PageBean<Staff> findByPage(int pageNum,int pageSize);

    PageBean<Staff> findByCD(List<Object> params,int pageNum,int pageSize);

    // 登录
    Staff findSingle(Map<String,Object> params);

    Staff login(Map<String,Object> params1);

}
