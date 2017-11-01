package com.lanou.teach.domain;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class CourseType {

    private String courseTypeID; // 主键ID
    private double courseCost; // 课程费用
    private int total; // 总课时
    private String courseName; // 课程类别名称
    private String remark; // 课程介绍模板
    private List<CourseType> courseTypes;

    public CourseType(String courseTypeID, double courseCost, int total, String courseName, String remark) {
        this.courseTypeID = courseTypeID;
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public CourseType(double courseCost, int total, String courseName, String remark) {
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public CourseType() {
    }

    public String getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(String courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CourseType(List<CourseType> courseTypes) {
        this.courseTypes = courseTypes;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeID='" + courseTypeID + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public List<CourseType> getCourseTypes() {
        return courseTypes;
    }

    public void setCourseTypes(List<CourseType> courseTypes) {
        this.courseTypes = courseTypes;
    }
}
