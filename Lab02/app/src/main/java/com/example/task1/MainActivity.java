package com.example.task1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String name[] = {"Thùy Trang", "Thanh Vinh", "Hoàng Thiện", "Hoàng Vũ"};
    ArrayList<String> myList;
    MyArrayAdapter myArrayAdapter;
    ListView lv;
    TextView tv;

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
        myList = new ArrayList<>();
        for (String s : name) myList.add(s);

        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.list_view_item, myList);
        lv.setAdapter(myArrayAdapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            if (tv != null) {
                tv.setText(getString(R.string.item_click_message, position, name[position]));
            }
        });
    }
}