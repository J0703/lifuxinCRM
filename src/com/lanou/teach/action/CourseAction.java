package com.lanou.teach.action;

import com.lanou.teach.domain.CourseType;
import com.lanou.teach.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
@Controller("courseAction")
@Scope("prototype")
public class CourseAction extends ActionSupport implements ModelDriven<CourseType> {
    private CourseType courseTypeDriven;
    @Qualifier("courseService")
    @Autowired
    private CourseService courseService;
    private List<CourseType> courseTypeList;
    private CourseType course;
    private String courseTypeID;


    // 添加课程
    public String addCourse() {
        if (!StringUtils.isBlank(courseTypeDriven.getCourseTypeID())) {
            courseService.update(courseTypeDriven);
        } else {
            courseService.save(courseTypeDriven);
        }
        return SUCCESS;
    }
    // 对于编辑和添加页面的验证
    public void validateAddCourse() {
       if (StringUtils.isBlank(courseTypeDriven.getCourseName())){
           addActionError("课程类别不能为空!");
       }
       if (courseTypeDriven.getTotal() <= 0){
           addActionError("你总不能不上课吧!");
       }
       if (courseTypeDriven.getCourseCost() < 0){
           addActionError("还有免费授课?");
       }
       if (StringUtils.isBlank(courseTypeDriven.getRemark())){
           addActionError("课程简介不能为空!");
       }

    }

    // 查询所有课程
    public String findCourse() {
        courseTypeList = courseService.findAll();
        System.out.println(courseTypeList);
        return SUCCESS;
    }


    // 查询所点击的对象
    public String findSingle(){
        course = courseService.get(CourseType.class, courseTypeDriven.getCourseTypeID());
        return SUCCESS;
    }


    // 驱动模型
    @Override
    public CourseType getModel() {
        courseTypeDriven = new CourseType();
        return courseTypeDriven;
    }

    public List<CourseType> getCourseTypeList() {
        return courseTypeList;
    }

    public void setCourseTypeList(List<CourseType> courseTypeList) {

        this.courseTypeList = courseTypeList;
    }

    public CourseType getCourse() {
        return course;
    }

    public void setCourse(CourseType course) {
        this.course = course;
    }

    public String getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(String courseTypeID) {
        this.courseTypeID = courseTypeID;
    }
}
