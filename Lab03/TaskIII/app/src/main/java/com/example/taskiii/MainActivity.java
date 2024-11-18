package com.example.taskiii;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private com.example.taskiii.StudentAdapter adapter;
    private com.example.taskiii.DatabaseHelper db;
    private List<com.example.taskiii.Student> sinhVienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        db = new com.example.taskiii.DatabaseHelper(this);
        sinhVienList = db.getAllStudents();

        adapter = new com.example.taskiii.StudentAdapter(sinhVienList, this, sinhVien -> {
            // Mở chi tiết sinh viên
            Intent intent = new Intent(MainActivity.this, com.example.taskiii.StudentDetailActivity.class);
            intent.putExtra("student_id", sinhVien.getId());
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnAddStudent).setOnClickListener(v -> {
            // Thêm sinh viên
            Intent intent = new Intent(MainActivity.this, com.example.taskiii.AddEditStudentActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList.clear(); // Xóa danh sách cũ
        List<com.example.taskiii.Student> newStudents = db.getAllStudents(); // Cập nhật lại danh sách từ cơ sở dữ liệu
        if (newStudents != null) {
            sinhVienList.addAll(newStudents);
        }
        adapter.notifyDataSetChanged(); // Cập nhật RecyclerView
    }
}