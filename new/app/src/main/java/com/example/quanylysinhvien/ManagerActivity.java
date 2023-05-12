package com.example.quanylysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.quanylysinhvien.loginandregisteractivity.LoginActivity;

public class ManagerActivity extends AppCompatActivity  {
    ImageView btnLop , btnSinhVien, btnInFo, btnWebste;
    Animation animation;
    TextView tv1,tv2,tv3,tv4;
    GridLayout gridLayout;
    ImageView imageViewMenu;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        btnLop = findViewById(R.id.btnLop);

        gridLayout = findViewById(R.id.girdviewManager);
        btnSinhVien = findViewById(R.id.btnsinhvien);


        tv1 = findViewById(R.id.tvclass);
        tv2 = findViewById(R.id.tvstudent);
        tv3 = findViewById(R.id.tvwebsite);
        tv4 = findViewById(R.id.tvketqua);

        btnInFo = findViewById(R.id.btnKetQua);
        btnWebste = findViewById(R.id.btnwebsite);
        imageViewMenu = findViewById(R.id.imageViewMenu);


        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = (ImageView) v;
                final PopupMenu popupMenu = new PopupMenu(ManagerActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.drawer_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.menuDangXuat:
                                intent = new Intent(ManagerActivity.this, LoginActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
                                break;
                        }
                        return true;
                    }
                });
            }
        });
        animation = AnimationUtils.loadAnimation(ManagerActivity.this, R.anim.bottom_top);
        gridLayout.setAnimation(animation);
        btnInFo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerActivity.this, DiemActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerActivity.this, DiemActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerActivity.this, DanhSachLopActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerActivity.this, DanhSachLopActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        btnSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhSachLopActivity.xetList = false;
                startActivity(new Intent(ManagerActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhSachLopActivity.xetList = false;
                startActivity(new Intent(ManagerActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        btnWebste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://phenikaa-uni.edu.vn/vi"));
                startActivity(myWebLink);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://phenikaa-uni.edu.vn/vi"));
                startActivity(myWebLink);
            }
        });

    }

    public void onRestart () {

        super.onRestart();

    }
    public void onResume () {

        super.onResume();

    }




}
