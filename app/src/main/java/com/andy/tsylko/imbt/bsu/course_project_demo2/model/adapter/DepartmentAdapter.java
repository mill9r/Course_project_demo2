package com.andy.tsylko.imbt.bsu.course_project_demo2.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.andy.tsylko.imbt.bsu.course_project_demo2.R;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Department;
import com.andy.tsylko.imbt.bsu.course_project_demo2.entity.Faculty;

import java.util.List;

/**
 * Created by Administrator on 12/13/2016.
 */

public class DepartmentAdapter extends ArrayAdapter<Department> {
    public DepartmentAdapter(Context context, List<Department> objects) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.department_list, parent, false);
        }
        // Get the {@link Faculty} object located at this position in the list
        Department currentDepartment = getItem(position);

        // Find the TextView in the faculty.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.department_name);

        // Get the version name from the current Faculty object and
        // set this text on the name TextView
        nameTextView.setText(currentDepartment.getDepartmentName());
        // Return the list item layout (containing 1 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
