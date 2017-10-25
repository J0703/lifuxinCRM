package com.lanou.hr.domain;



/**
 * Created by dllo on 17/10/25.
 */
public class Department {

    private String depID;
    private String depName;



    public Department() {
    }

    public Department(String depID, String depName) {
        this.depID = depID;
        this.depName = depName;
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                '}';
    }
}
