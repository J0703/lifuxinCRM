package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.DepartmentService;
import com.lanou.hr.service.PostService;
import com.lanou.hr.service.StaffService;

import com.lanou.hr.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;
    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    @Qualifier("postService")
    @Autowired
    private PostService postService;
    private List<Staff> staffs;
    private List<Department> departments;
    private Staff staffDriven;

    private String postId;
    private String depID;
    private Staff staff;

    private int pageNum;
    private int pageSize = 5;

    // 查询所有员工
    public String findAll() {
        staffs = staffService.findAll();
        return SUCCESS;
    }

    // 表单回显
    public String showStaff() {
        Serializable id = staffDriven.getStaffId();
        System.out.println("id" + id);
        departments = departmentService.findAll();
        staff = staffService.get(Staff.class, id);
        return SUCCESS;
    }

    // 添加员工
    public String addStaff() {
        Post post = postService.get(Post.class, postId);
        Date date = staffDriven.getOnDutyDate();
        Staff staff1 = new Staff(staffDriven.getLoginName(), staffDriven.getLoginPwd(), staffDriven.getStaffName(), staffDriven.getGender(), date);
        staff1.setPost(post);
        staff1.setDepartment(post.getDepartment());
        staffService.add(staff1);
        return SUCCESS;
    }

    // 编辑员工
    public String updateStaff() {
        String postId = staffDriven.getPost().getPostId().trim();
        Post post = postService.get(Post.class, postId);
        if (post != null) {
            staffDriven.setPost(post);
            staffDriven.setDepartment(post.getDepartment());
        }
        staffService.update(staffDriven);
        return SUCCESS;
    }

    // 高级查询
    public String findStaff() {
        staffs = staffService.findStaff(staffDriven, depID, postId);
        return SUCCESS;
    }


    // 查询分页
    public String findBypage() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Staff> pageBean = staffService.findByPage(pageNum, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        return SUCCESS;
    }


    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Staff getModel() {
        staffDriven = new Staff();
        return staffDriven;
    }
}
