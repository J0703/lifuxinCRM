package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.DepartmentService;
import com.lanou.hr.service.StaffService;
import com.lanou.hr.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.List;


/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    private String depName;
    private String depId;
    private Department department;
    private List<Department> departments;

    // 分页
    private int pageNum;
    private int pageSize = 5;
    private Department departmentDriven;

    // 查询所有部门
    public String findDepartment() {
        departments = departmentService.findAll();
        return SUCCESS;
    }

    public String findSingle() {
        Serializable id = depId;
        department = departmentService.get(Department.class, id);
        return SUCCESS;
    }


    // 添加一个部门
    public String save() {
        if (StringUtils.isBlank(departmentDriven.getDepID())) {
            if (StringUtils.isBlank(departmentDriven.getDepName())) {
                ActionContext.getContext().getApplication().put("msg", "部门或职务不能为空!");
                return INPUT;
            } else {
                Department department = new Department(departmentDriven.getDepName());
                departmentService.save(department);
            }
        } else {
            Department department = new Department(departmentDriven.getDepID(), departmentDriven.getDepName());
            departmentService.update(department);
        }
        return SUCCESS;
    }

    // 分页查询department
    public String findByPage() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Department> pageBean = departmentService.findByPage(pageNum, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        return SUCCESS;
    }


    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
    public Department getModel() {
        departmentDriven = new Department();
        return departmentDriven;
    }
}
