package com.lanou.hr.test;

import com.lanou.hr.action.DepartmentAction;
import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.dao.impl.DepartmentDaoImpl;
import com.lanou.hr.domain.Department;
import com.lanou.hr.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void testDao(){
//        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
//        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        DepartmentAction departmentAction = (DepartmentAction) context.getBean("departmentAction");

//        List<Department> departments = departmentService.findAll();
//        for (Department de : departments) {
//            System.out.println(de);
//        }
        departmentAction.findDepartment();
        System.out.println(departmentAction);
    }



}
