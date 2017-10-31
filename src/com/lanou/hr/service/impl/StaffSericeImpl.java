package com.lanou.hr.service.impl;

import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import com.lanou.hr.util.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public class StaffSericeImpl implements StaffService {

    private StaffDao staffDao;
    private Staff staff;

    @Override
    public List<Staff> findAll() {
        String hql = "from Staff";
        return staffDao.findAll(hql);
    }

    @Override
    public Staff get(Class<Staff> c, Serializable id) {
        return staffDao.get(c, id);
    }

    @Override
    public void add(Staff staff) {
        staffDao.save(staff);
    }

    // 更新员工
    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public List<Staff> findStaff(Staff staff, String depId, String postId) {
        List<String> params = new ArrayList<>();
        StringBuilder sb = new StringBuilder(" from Staff s where 1=1");
        // 按部门查,或者按部门和职务查询
        if (!depId.equals("-1") && postId.equals("-1") && StringUtils.isBlank(staff.getStaffName())) {
            sb.append(" and s.post.department.depID =?");
            params.add(depId);
        } else if (!depId.equals("-1") && !postId.equals("-1") && StringUtils.isBlank(staff.getStaffName())) {
            sb.append(" and s.post.department.depID =?");
            params.add(depId);
            sb.append(" and s.post.postId =?");
            params.add(postId);
        } else if (!depId.equals("-1") && postId.equals("-1") && !StringUtils.isBlank(staff.getStaffName())) {
            sb.append(" and s.post.department.depID=?");
            params.add(depId);
            sb.append(" and staffName =?");
            params.add(staff.getStaffName());
        } else if (depId.equals("-1") && postId.equals("-1") && StringUtils.isBlank(staff.getStaffName())) {
            sb.append("");
        } else if (depId.equals("-1") && postId.equals("-1")) { // 按姓名查询
            sb.append(" and staffName =?");
            params.add(staff.getStaffName());
        }
        return staffDao.find(sb.toString(), params.toArray());
    }



    @Override
    public PageBean<Staff> findByPage(int pageNum, int pageSize) {
        String hql = "select count(*) from Staff";
        String hql1 = "from Staff where 1=1";
        int totalRecord = staffDao.getTotalRecord(hql);
        PageBean<Staff> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Staff> data = staffDao.findALL(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    @Override
    public PageBean<Staff> findByCD(List<Object> params, int pageNum, int pageSize) {
        String hql = "select count(*) from Staff where 1=1";
        String hql1 = "from Staff where 1=1";
        int totalRecord = staffDao.getTotalRecondStaff(hql,params);
        PageBean<Staff> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Staff> data = staffDao.findByCD(hql1,params,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;}

    @Override
    public Staff findSingle(Map<String, Object> params) {
        String hql = "from Staff where loginName =:loginName";
        return staffDao.findSingle(hql,params);
    }

    @Override
    public Staff login(Map<String, Object> params) {
        String hql = "from Staff where loginName =:loginName and loginPwd =:loginPwd";
        return staffDao.findSingle(hql,params);
    }


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
