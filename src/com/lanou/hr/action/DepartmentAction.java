package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;


/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport {

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    private String depName;
    private String depId;
    private Department department;
    private List<Department> departments;

    // 查询所有部门
    public String findDepartment() {
        departments = departmentService.findAll();
//        System.out.println("department"+departments);
//        ServletActionContext.getRequest().getSession().setAttribute("departments", departments);
        return SUCCESS;
    }

    public String findSingle() {
        Serializable id = depId;
        System.out.println(depId);
        department = departmentService.get(Department.class, id);
        return SUCCESS;
    }


    // 添加一个部门
    public String save() {
        System.out.println("departID" + depId);
        if (StringUtils.isBlank(depId)) {
            if (StringUtils.isBlank(depName)) {
                addActionError("输入的数据不能为空!");
                return INPUT;
            } else {
                Department department = new Department(depName);
                departmentService.save(department);
            }
        } else {
            Department department = new Department(depId, depName);
            departmentService.update(department);
        }
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
}
