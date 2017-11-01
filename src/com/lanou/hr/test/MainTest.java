package com.lanou.hr.test;

import com.lanou.hr.action.DepartmentAction;
import com.lanou.hr.action.PostAction;
import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.dao.PostDao;
import com.lanou.hr.dao.impl.DepartmentDaoImpl;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.DepartmentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SourceType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.util.Date;
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
    @Test
    public void testDao1(){
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department("财务部1");
        Post post = new Post("会计1");
        post.setDepartment(department);
        department.getPosts().add(post);
        session.save(department);
        Staff staff = new Staff("lifuxin","123","李福鑫","男",new Date());
        staff.setPost(post);

        session.save(staff);
        transaction.commit();

    }

}
