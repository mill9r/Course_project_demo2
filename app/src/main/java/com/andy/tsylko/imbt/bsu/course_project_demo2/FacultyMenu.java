package com.andy.tsylko.imbt.bsu.course_project_demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.tsylko.imbt.bsu.course_project_demo2.database.DatabaseAdapter;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Faculty;
import com.andy.tsylko.imbt.bsu.course_project_demo2.model.adapter.FacultyAdapter;

import java.util.List;

public class FacultyMenu extends AppCompatActivity {
    private List<Faculty> facultyList;
    private TextView tv;
    private final String DEPARTMENT = "department";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_menu);

        DatabaseAdapter d = new DatabaseAdapter(this);
        d.open();
        facultyList = d.getAllFaculties();
        d.close();

        FacultyAdapter adapter = new FacultyAdapter(this, facultyList);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) findViewById(R.id.activity_faculty_menu);
        listView.setAdapter(adapter);


        // this method allows to make the listview clickable
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FacultyMenu.this, DepartmentMenu.class);
                String item = listView.getItemAtPosition(i).toString();
                intent.putExtra(DEPARTMENT, item);
                startActivity(intent);

            }
        });

    }
}
