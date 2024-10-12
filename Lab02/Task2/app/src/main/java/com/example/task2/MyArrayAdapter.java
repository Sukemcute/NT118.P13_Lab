package com.example.task2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final int idLayout;
    private final ArrayList<String> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<String> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        // Kiểm tra xem convertView có cần tái sử dụng không
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(idLayout, parent, false);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.tv); // Đảm bảo ID này đúng
            convertView.setTag(holder); // Lưu ViewHolder vào convertView
        } else {
            holder = (ViewHolder) convertView.getTag(); // Lấy ViewHolder từ convertView
        }

        // Thiết lập dữ liệu
        holder.tv.setText(myList.get(position));
        return convertView;
    }

    // Class ViewHolder để tối ưu hóa
    static class ViewHolder {
        TextView tv;
    }
}