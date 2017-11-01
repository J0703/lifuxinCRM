package com.lanou.teach.domain;

import java.util.Date;

/**
 * Created by dllo on 17/10/31.
 */
public class Classes {

    private String classID; // 主键id
    private String lessionTypeID; // 所属课程id
    private String name; // 班级名称
    private Date beginTime; // 开班时间
    private Date endTime; // 毕业时间
    private int status; // 课程状态
    private int totalCount; // 学生总数
    private int upgradeCount; // 升班数
    private int changeCount; // 转班数
    private int runoffCount; // 退费数
    private String remark; // 其他说明
    private String uploadPath; // 课表路径
    private String uploadFileName; //课表名称
    private String uploadTime; // 上传时间
    private CourseType courseType;

    public Classes(String classID, String lessionTypeID, String name, Date beginTime, Date endTime, int status, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, String uploadTime) {
        this.classID = classID;
        this.lessionTypeID = lessionTypeID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
    }

    public Classes() {
    }

    public Classes(String lessionTypeID, String name, Date beginTime, Date endTime, int status, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, String uploadTime) {
        this.lessionTypeID = lessionTypeID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classID='" + classID + '\'' +
                ", lessionTypeID='" + lessionTypeID + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", courseType=" + courseType +
                '}';
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getLessionTypeID() {
        return lessionTypeID;
    }

    public void setLessionTypeID(String lessionTypeID) {
        this.lessionTypeID = lessionTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {

        this.uploadTime = uploadTime;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
