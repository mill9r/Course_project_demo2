package com.andy.tsylko.imbt.bsu.course_project_demo2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView eval_teach;
    private TextView teach_rating;
    private TextView teach_progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        eval_teach = (TextView) findViewById(R.id.evaluate_teacher);
        teach_progress = (TextView) findViewById(R.id.teacher_progress);
        teach_rating = (TextView) findViewById(R.id.teacher_rating);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

























        Typeface t = Typeface.createFromAsset(getAssets(),
                "fonts/Intro.ttf");
        eval_teach.setTypeface(t, Typeface.NORMAL);
        teach_progress.setTypeface(t, Typeface.NORMAL);
        teach_rating.setTypeface(t, Typeface.NORMAL);
    }

}
