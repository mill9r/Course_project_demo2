package com.andy.tsylko.imbt.bsu.course_project_demo2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.tsylko.imbt.bsu.course_project_demo2.database.DatabaseAdapter;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Faculty;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView eval_teach;
    private TextView teach_rating;
    private TextView teach_progress;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_exit:

                return true;

            case R.id.action_help:

                return true;

            case R.id.action_about:

                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }

    //sharepreference
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        eval_teach = (TextView) findViewById(R.id.evaluate_teacher);
        teach_progress = (TextView) findViewById(R.id.teacher_progress);
        teach_rating = (TextView) findViewById(R.id.teacher_rating);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        Typeface t = Typeface.createFromAsset(getAssets(),
                "fonts/Intro.ttf");

        eval_teach.setTypeface(t, Typeface.NORMAL);
        teach_progress.setTypeface(t, Typeface.NORMAL);
        teach_rating.setTypeface(t, Typeface.NORMAL);


        teach_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, FacultyMenu.class);
                startActivity(intent);
            }
        });


        eval_teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseAdapter d = new DatabaseAdapter(MainMenu.this);
                d.open();
                List<Faculty> f = new ArrayList<Faculty>();

                f = d.getAllFaculties();
                Toast.makeText(MainMenu.this, String.valueOf(f.size()), Toast.LENGTH_LONG).show();
                d.close();

            }
        });


        teach_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseAdapter d = new DatabaseAdapter(MainMenu.this);
                d.open();

//                 faculties
                d.insertFaculty("Физический");
                d.insertFaculty("Химический");
                d.insertFaculty("Биологический");
                d.insertFaculty("Географический");
                d.insertFaculty("Филологический");
                d.insertFaculty("Экономический");
                d.insertFaculty("Исторический");
                d.insertFaculty("Прикладной математики и информатики");

                d.insertDepartment("Кафедра общей физики",1);
                d.insertDepartment("Кафедра биофизики",1);
                d.insertDepartment("Кафедра компьютерного моделирования",1);
                d.insertDepartment("Кафедра высшей математики и математической физики",1);
                d.insertDepartment("Кафедра энергофизики",1);
                d.insertDepartment("Кафедра ядерной физики",1);
                d.insertDepartment("Кафедра методики преподавания физики и информатики",1);
                d.insertDepartment("Кафедра физики полупроводников и наноэлектроники",1);

                d.insertGroup(220098, 2, 2016, 9, 12);
                d.insertGroup(230090, 2, 2015, 9, 12);
                d.insertGroup(244000, 2, 2014, 9, 12);


                d.insertStudent("Андрей", "Ваганов", 101, 220098, "101");
                d.insertStudent("Дмитрий", "Эль", 102, 220098, "102");
                d.insertStudent("Вагит", "Алекперов", 103, 220098, "103");
                d.insertStudent("Леонов", "Сергей", 104, 220098, "105");
                d.insertStudent("Хоркхаймер", "Макс", 105, 220098, "105");


                d.insertTeacher("Герман","Олег","Витольдович",1001,"кандидат технических наук",2);
                d.insertTeacher("Дерюшев","Андрей","Анатольевич",1002,"кандидат технических наук",2);
                d.insertTeacher("Иванченко","Виктор","Владимирович",1003,"магистр",2);


                d.close();
                Toast.makeText(MainMenu.this, "Database is create", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
