package com.andy.tsylko.imbt.bsu.course_project_demo2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 12/13/2016.
 */

public class Time {
    public static long getDateTime(int year, int month, int date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        Date t = new Date(year, month, date);
        long time = t.getTime();
        return time;
    }
}
