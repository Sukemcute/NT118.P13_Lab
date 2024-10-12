package com.example.task3.employee_classes;
public class EmployeePartTime extends Employee {
    public EmployeePartTime(String employId, String employName) {
        super(employId, employName);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double tinhLuong() {
        return 150.0;
    }
}