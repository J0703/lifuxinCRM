package com.lanou.hr.service.impl;
import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
public class StaffSericeImpl implements StaffService {

    private StaffDao staffDao;
    @Override
    public List<Staff> findAll() {
        String hql = "from Staff";
        return staffDao.findAll(hql);
    }

    @Override
    public Staff get(Class<Staff> c, Serializable id) {
        return staffDao.get(c,id);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
