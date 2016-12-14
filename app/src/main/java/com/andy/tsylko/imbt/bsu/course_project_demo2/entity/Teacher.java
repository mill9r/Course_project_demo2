package com.andy.tsylko.imbt.bsu.course_project_demo2.entity;

/**
 * Created by Administrator on 12/13/2016.
 */

public class Teacher {
    private String name;
    private String lastname;
    private String patronymic;
    private int ContractNumber;
    private String AcademicDegree;
    private int TeacherDepartment;

    public Teacher(String name, String lastname, String patronymic, String academicDegree) {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        AcademicDegree = academicDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAcademicDegree() {
        return AcademicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        AcademicDegree = academicDegree;
    }
}
