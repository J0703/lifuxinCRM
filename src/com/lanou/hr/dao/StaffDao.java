package com.lanou.hr.dao;


import com.lanou.hr.domain.Staff;

import java.util.List;
import java.util.Map;


/**
 * Created by dllo on 17/10/26.
 */
public interface StaffDao extends BaseDao<Staff> {




    int getTotalRecondStaff(String hql,List<Object> params);

    List<Staff> findByCD(String sql1,List<Object> params,int startIndex,int pageSize);


}
