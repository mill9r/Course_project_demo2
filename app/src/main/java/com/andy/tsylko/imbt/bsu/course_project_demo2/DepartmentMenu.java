package com.andy.tsylko.imbt.bsu.course_project_demo2;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.tsylko.imbt.bsu.course_project_demo2.database.DatabaseAdapter;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Department;
import com.andy.tsylko.imbt.bsu.course_project_demo2.model.adapter.DepartmentAdapter;
import com.andy.tsylko.imbt.bsu.course_project_demo2.model.adapter.FacultyAdapter;


import java.util.List;

public class DepartmentMenu extends AppCompatActivity {
    private List<Department> departmentList;

    private final String DEPARTMENT = "department";
    private Intent intent;
    private String intentString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_menu);

        intent = getIntent();
        intentString = intent.getStringExtra(DEPARTMENT);

        Toast.makeText(this,intentString, Toast.LENGTH_SHORT).show();
        DatabaseAdapter d = new DatabaseAdapter(this);
        d.open();
        departmentList = d.getAllDepartment(intentString);
        System.out.println("departemtn list\n");
        for (int i = 0; i <departmentList.size() ; i++) {
            System.out.println(departmentList.get(i));
        }
        d.close();

        DepartmentAdapter adapter = new DepartmentAdapter(this, departmentList);

//        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) findViewById(R.id.activity_department_menu);
        listView.setAdapter(adapter);
    }

}
