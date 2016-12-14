package com.andy.tsylko.imbt.bsu.course_project_demo2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 12/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "teacherRank.db";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tblFaculty (\n" +
                "    FacultyID   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                        NOT NULL\n" +
                "                        UNIQUE,\n" +
                "    FacultyName TEXT    NOT NULL\n" +
                "                        UNIQUE\n" +
                ");");
        db.execSQL("CREATE TABLE tblSubject (\n" +
                "    SubjectName TEXT    NOT NULL,\n" +
                "    SubjectID   INTEGER NOT NULL\n" +
                "                        UNIQUE\n" +
                "                        PRIMARY KEY\n" +
                ");");

        db.execSQL("CREATE TABLE tblDepartment (\n" +
                "    DepartmentID   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                           UNIQUE\n" +
                "                           NOT NULL,\n" +
                "    FacultyID      INTEGER REFERENCES tblFaculty (FacultyID) ON DELETE CASCADE\n" +
                "                                                             ON UPDATE CASCADE\n" +
                "                           NOT NULL,\n" +
                "    DepartmentName TEXT    UNIQUE\n" +
                "                           NOT NULL\n" +
                ");");

        db.execSQL("CREATE TABLE tblGroup (\n" +
                "    GroupID      INTEGER PRIMARY KEY\n" +
                "                         UNIQUE\n" +
                "                         NOT NULL,\n" +
                "    DepartmentID INTEGER REFERENCES tblDepartment (DepartmentID) ON DELETE CASCADE,\n" +
                "    CreationTime DATE    NOT NULL\n" +
                ");");
        db.execSQL("CREATE TABLE tblStudent (\n" +
                "    Name      TEXT,\n" +
                "    LastName  TEXT    NOT NULL,\n" +
                "    StudentID INTEGER PRIMARY KEY\n" +
                "                      UNIQUE\n" +
                "                      NOT NULL,\n" +
                "    GroupID   INTEGER REFERENCES tblGroup ON DELETE CASCADE,\n" +
                "    Password  TEXT    NOT NULL\n" +
                ");\n");
        db.execSQL("CREATE TABLE tblTeacher (\n" +
                "    Name                TEXT,\n" +
                "    LastName            TEXT    NOT NULL,\n" +
                "    Patronymic          TEXT,\n" +
                "    ContractNumber      INTEGER PRIMARY KEY\n" +
                "                                UNIQUE\n" +
                "                                NOT NULL,\n" +
                "    AcademicDegree      TEXT,\n" +
                "    TeacherDepartmentID INTEGER REFERENCES tblTeacherDepartment ON DELETE CASCADE\n" +
                "                                NOT NULL\n" +
                ");");
        db.execSQL("CREATE TABLE tblTeacherResult (\n" +
                "    ResultID       INTEGER PRIMARY KEY\n" +
                "                           UNIQUE\n" +
                "                           NOT NULL,\n" +
                "    Date           DATE    DEFAULT CURRENT_DATE  NOT NULL,\n" +
                "    ContractNumber         REFERENCES tblTeacher ON DELETE NO ACTION\n" +
                "                           NOT NULL,\n" +
                "    AvgSum         DOUBLE,\n" +
                "    Question1      INTEGER,\n" +
                "    Question2      INTEGER,\n" +
                "    Question3      INTEGER,\n" +
                "    Question4      INTEGER,\n" +
                "    Question5      INTEGER,\n" +
                "    Question6      INTEGER,\n" +
                "    Question7      INTEGER,\n" +
                "    Question8      INTEGER,\n" +
                "    SubjectID      INTEGER REFERENCES tblSubject (SubjectID) ON DELETE CASCADE\n" +
                "                                                             ON UPDATE CASCADE\n" +
                "                           NOT NULL,\n" +
                "    StudentID      INTEGER REFERENCES tblStudent (StudentID) ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n" +
                ");");

        db.execSQL(" CREATE TABLE tblSemester (\n" +
                "                SemesterID      INTEGER PRIMARY KEY,\n" +
                "                CurrentSemester INTEGER NOT NULL,\n" +
                "                ContractNumber  INTEGER REFERENCES tblTeacher (ContractNumber) ON DELETE CASCADE\n" +
                "                ON UPDATE CASCADE,\n" +
                "                GroupID         INTEGER REFERENCES tblGroup (GroupID) ON DELETE CASCADE\n" +
                "                ON UPDATE CASCADE,\n" +
                "                SubjectID       INTEGER REFERENCES tblSubject (SubjectID) ON DELETE CASCADE\n" +
                "                ON UPDATE CASCADE\n" +
                "        );\n");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
