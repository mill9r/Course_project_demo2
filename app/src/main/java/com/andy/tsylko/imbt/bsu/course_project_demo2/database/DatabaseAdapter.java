package com.andy.tsylko.imbt.bsu.course_project_demo2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.andy.tsylko.imbt.bsu.course_project_demo2.Time;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Department;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Faculty;

import java.util.ArrayList;
import java.util.List;

/**
 * Here was created a DAO class
 */

public class DatabaseAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    //Constructor, that create a database helper and I provided an application context
    // to make this things global.
    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }

    //open and close methods
    // open method delegates down to the helper to call get writable or close if that needed.
    //that take cares of opening and closing the database.
    public DatabaseAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private Cursor getAllElements() {

        String[] columns = new String[1];
        columns[0] = "FacultyName";
        return database.query("tblFaculty", columns, null, null, null, null, null);

    }


    public List<Faculty> getAllFaculties() {

        ArrayList<Faculty> faculty = new ArrayList<>();
        Cursor cursor = getAllElements();
        if (cursor.moveToFirst()) {
            do {
                faculty.add(new Faculty(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return faculty;

    }


    private Cursor getAllDepartments(String name) {
        return database.rawQuery("select D.DepartmentName from tblDepartment as D "
                + " inner join tblFaculty as F" +
                " on F.FacultyID=D.FacultyID" +
                " where FacultyName = ?", new String[]{name});
    }


    public List<Department> getAllDepartment(String name) {
        ArrayList<Department> department = new ArrayList<>();
        Cursor cursor = getAllDepartments(name);
        if (cursor.moveToFirst()) {
            do {
                department.add(new Department(cursor.getString(cursor.getColumnIndex("DepartmentName"))));
            } while (cursor.moveToNext());
        }
        for (int i = 0; i < department.size(); i++) {
            System.out.println(department.get(i));
        }
        cursor.close();
        return department;
    }


    public void insertFaculty(String name) {

        ContentValues values = new ContentValues();
        values.put("FacultyName", name);
        database.insert("tblFaculty", null, values);

    }

    public void insertDepartment(String name, int id) {

        ContentValues values = new ContentValues();
        values.put("DepartmentName", name);
        values.put("FacultyID", id);
        database.insert("tblDepartment", null, values);

    }

    public void insertTeacher(String name, String lname, String patronymic, int contractNumber, String academicDegree, int TeacherDepartmentID) {
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("LastName", lname);
        values.put("Patronymic", patronymic);
        values.put("ContractNumber", contractNumber);
        values.put("AcademicDegree", academicDegree);
        values.put("TeacherDepartmentID", TeacherDepartmentID);
        database.insert("tblTeacher", null, values);
    }

    public void insertGroup(int GroupID, int DepartmentID, int year, int month, int day) {
        ContentValues values = new ContentValues();
        values.put("GroupID", GroupID);
        values.put("DepartmentID", DepartmentID);
        values.put("CreationTime", Time.getDateTime(year, month, day));
        database.insert("tblGroup", null, values);


    }

    public void insertStudent(String name, String lastname, int StudentID, int GroupID, String password) {
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("LastName", lastname);
        values.put("StudentID", StudentID);
        values.put("GroupID", GroupID);
        values.put("Password", password);
        database.insert("tblStudent", null, values);
    }

    public void insertSubject(String subjectName, int subjectID) {
        ContentValues values = new ContentValues();
        values.put("SubjectName", subjectName);
        values.put("SubjectID", subjectID);
        database.insert("tblSubject", null, values);
    }

    public void insertTimeTable(int timeTableID, int currentSemester, int contractNumber, int groupID, int subjectID) {
        ContentValues values = new ContentValues();
        values.put("SemesterID", timeTableID);
        values.put("CurrentSemester", currentSemester);
        values.put("ContractNumber", contractNumber);
        values.put("GroupID", groupID);
        values.put("SubjectID", subjectID);
        database.insert("tblSemester", null, values);
    }

    public void insertRank(int resultID, int contractNumber, int q1, int q2, int q3, int q4, int q5, int q6, int q7, int q8, int subjectID, int studentID) {
        ContentValues values = new ContentValues();
        values.put("ResultID", resultID);
        values.put("ContractNumber", contractNumber);
        values.put("Question1", q1);
        values.put("Question2", q2);
        values.put("Question3", q3);
        values.put("Question4", q4);
        values.put("Question5", q5);
        values.put("Question6", q6);
        values.put("Question7", q7);
        values.put("Question8", q8);
        values.put("SubjectID", subjectID);
        values.put("StudentID", studentID);
        database.insert("tblTeacherResult", null, values);
    }
}
