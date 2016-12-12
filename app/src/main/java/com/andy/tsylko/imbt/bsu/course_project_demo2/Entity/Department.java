package com.andy.tsylko.imbt.bsu.course_project_demo2.Entity;

/**
 * Created by Administrator on 12/12/2016.
 */

public class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }
}
