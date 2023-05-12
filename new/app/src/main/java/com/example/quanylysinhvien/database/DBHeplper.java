package com.example.quanylysinhvien.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanylysinhvien.R;
import com.example.quanylysinhvien.model.SinhVien;

import java.util.ArrayList;

public class DBHeplper extends SQLiteOpenHelper {
    public DBHeplper(@Nullable Context context) {
        super(context, "QUANLYSINHVIENPKAAUDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //tạo table lớp
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('OOP1','Lap trinh huong doi tuong')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('CPP1','Ngon ngu c++')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('TUH1','Toi uu hoa')";
        db.execSQL(sql);
        //tạo table sinh viên
        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT ," + " email TEXT ,hinh TEXT,diem TEXT, maLop TEXT REFERENCES LOP(maLop))";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('001','Bùi Quốc Việt','viet@gmail.com','phenikaa','9','OOP1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('002','Nguyễn Đức Anh Tuấn','anhtuan0411@gmail.com','phenikaa','8','CPP1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('003','Nguyễn Trí Vương','vuongHL@gmail.com','phenikaa','9','TUH1')";
        db.execSQL(sql);
        //tạo table taikhoan
        sql = "CREATE TABLE taiKhoan(tenTaiKhoan text primary key, matKhau text)";
        db.execSQL(sql);
        //tai khoan mac dinh admin
        sql = "INSERT INTO taiKhoan VALUES('admin','admin')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
