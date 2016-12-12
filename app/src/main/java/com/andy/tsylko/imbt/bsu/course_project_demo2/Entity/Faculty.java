package com.andy.tsylko.imbt.bsu.course_project_demo2.Entity;

/**
 * Created by Administrator on 12/2/2016.
 */

public class Faculty {
    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                '}';
    }
}
