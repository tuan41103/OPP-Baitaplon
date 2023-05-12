package com.example.quanylysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.quanylysinhvien.adapter.SinhVienAdapter;
import com.example.quanylysinhvien.dao.SinhVienDao;
import com.example.quanylysinhvien.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DiemActivity extends AppCompatActivity {
    private static boolean xetList;
    private static ArrayList<SinhVien> svlistDuocLoc;
    ListView listView;
    EditText edtSVID;
    public static ArrayList<SinhVien> ds = new ArrayList<>();
    ArrayList<SinhVien> TimKiem = new ArrayList<>();
    SinhVienAdapter sinhVienAdapter;
    SinhVienDao sinhVienDao;
    Boolean isOpen = false;

    Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem);
        btnsearch = findViewById(R.id.btnsearch);
        edtSVID = findViewById(R.id.student_id);
        listView = findViewById(R.id.grade_list);
        sinhVienDao = new SinhVienDao(DiemActivity.this);
        if (DiemActivity.xetList == true) {
            ds = DiemActivity.svlistDuocLoc;
        } else {
            ds = sinhVienDao.getALL();
        }
        TimKiem = sinhVienDao.getALL();
        sinhVienAdapter = new SinhVienAdapter(DiemActivity.this, ds);
        listView.setAdapter(sinhVienAdapter);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    // Nếu thanh tìm kiếm đã mở, thực hiện tìm kiếm
                    String keyword = edtSVID.getText().toString().toLowerCase();
                    if (keyword.length() > 0) {
                        TimKiem.clear();
                        for (SinhVien sv : ds) {
                            if (sv.getMaSv().toLowerCase().contains(keyword)) {
                                TimKiem.add(sv);
                            }
                        }
                        sinhVienAdapter = new SinhVienAdapter(DiemActivity.this, TimKiem);
                        listView.setAdapter(sinhVienAdapter);
                    } else {
                        sinhVienAdapter = new SinhVienAdapter(DiemActivity.this, ds);
                        listView.setAdapter(sinhVienAdapter);
                    }
                } else {
                    // Nếu thanh tìm kiếm chưa mở, mở nó ra
                    edtSVID.setVisibility(View.VISIBLE);
                    isOpen = true;
                }
            }
        });


    }

}
