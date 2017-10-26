package com.lanou.hr.action;

import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport{
    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;
    private List<Staff> staffs;
    private String staffId;
    private Staff staff;

    public String findAll(){
        staffs = staffService.findAll();
        return SUCCESS;
    }

    // 表单回显
    public String showStaff(){
        Serializable id = staffId;
        System.out.println("id" + id);
        staff = staffService.get(Staff.class, id);
        return SUCCESS;
    }



    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
