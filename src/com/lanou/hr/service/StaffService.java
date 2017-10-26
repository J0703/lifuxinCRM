package com.lanou.hr.service;


import com.lanou.hr.domain.Staff;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
public interface StaffService {

    List<Staff> findAll();

    Staff get(Class<Staff> c,Serializable id);

}
