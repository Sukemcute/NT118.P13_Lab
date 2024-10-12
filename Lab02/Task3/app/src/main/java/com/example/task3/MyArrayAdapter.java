package com.example.task3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.task3.employee_classes.Employee;
import com.example.task3.employee_classes.EmployeePartTime;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context;
    int IdLayout;
    ArrayList<Employee> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Employee> myList) {
        super(context, idLayout, myList);
        this.context = context;
        IdLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = context.getLayoutInflater();
        convertView = myInflater.inflate(IdLayout, null);
        Employee employee = myList.get(position);
        TextView tv = convertView.findViewById(R.id.text_view);
        if (employee instanceof EmployeePartTime)
            tv.setText(employee.getEmployId() + " - " + employee.getEmployName() + " -->PartTime=" +employee.tinhLuong());
        else
            tv.setText(employee.getEmployId() + " - " + employee.getEmployName() + " -->FullTime=" +employee.tinhLuong());
        return convertView;
    }
}