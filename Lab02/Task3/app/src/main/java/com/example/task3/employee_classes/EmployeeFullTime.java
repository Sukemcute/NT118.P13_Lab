package com.example.task3.employee_classes;

public class EmployeeFullTime extends Employee{
    public EmployeeFullTime(String employId, String employName) {
        super(employId, employName);
    }

    @Override
    public String toString() {return super.toString();}

    @Override
    public double tinhLuong() { return 500.0; }
}
