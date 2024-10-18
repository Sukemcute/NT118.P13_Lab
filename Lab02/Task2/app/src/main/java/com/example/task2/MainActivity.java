package com.example.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String name[] = {"Thùy Trang", "Thanh Vinh", "Hoàng Thiện", "Hoàng Vũ"};
    ArrayList<String> myList;
    MyArrayAdapter myArrayAdapter;
    ListView lv;
    TextView tv;
    Button button;
    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv = findViewById(R.id.lv);
        tv = findViewById(R.id.tv);
        edit_text = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        myList = new ArrayList<>();
        for (String s : name) myList.add(s);

        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.list_view_item, myList);
        lv.setAdapter(myArrayAdapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            tv.setText("Lê Thị Thùy Trang - 22521511\nposition: " + position + ", value = " + myList.get(position));
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            myList.remove(position);  // Xóa item tại vị trí được chọn
            myArrayAdapter.notifyDataSetChanged();  // Cập nhật adapter
            Toast.makeText(MainActivity.this, "Item đã bị xóa", Toast.LENGTH_SHORT).show();  // Thông báo
            return true;
        });

        button.setOnClickListener(v -> {
            String newItem = edit_text.getText().toString().trim();

            if (newItem.isEmpty()) {
                Toast.makeText(MainActivity.this, "Hãy nhập tên!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kiểm tra item đã tồn tại trong danh sách chưa
            if (myList.contains(newItem)) {
                Toast.makeText(MainActivity.this, "Tên đã tồn tại!", Toast.LENGTH_SHORT).show();
                edit_text.setText(""); // Xóa trường nhập liệu nếu đã tồn tại
                return;
            }

            // Nếu không tồn tại, thêm item vào danh sách
            myList.add(newItem);
            edit_text.setText(""); // Xóa nhập liệu
            myArrayAdapter.notifyDataSetChanged(); // Cập nhật adapter
            Toast.makeText(MainActivity.this, "Item đã được thêm!", Toast.LENGTH_SHORT).show(); // Thông báo
        });
    }
}