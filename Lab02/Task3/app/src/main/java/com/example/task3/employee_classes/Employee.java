package com.example.task3.employee_classes;

public class Employee {
    String employId, employName;

    public Employee(String employId, String employName) {
        this.employId = employId;
        this.employName = employName;
    }

    public double tinhLuong() {
        return 0;
    }

    public String toString() {return super.toString();}

    public String getEmployId() {
        return employId;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }
}