package com.example.thietkegiaodienapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thietkegiaodienapplication.LisUserActivity;
import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.adapter.DiemCao_Adapter;
import com.example.thietkegiaodienapplication.adapter.UserAdapter;
import com.example.thietkegiaodienapplication.dao.NhanVatDAO;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.model.NhanVat;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class TOPActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<NhanVat> nhanVats ;
    DiemCao_Adapter diemCao_adapter;
    NhanVatDAO nhanVatDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        recyclerView=findViewById(R.id.rvtop);
        nhanVatDAO=new NhanVatDAO(TOPActivity.this);
        nhanVats=nhanVatDAO.truyxuatnv();

        diemCao_adapter=new DiemCao_Adapter(nhanVats,TOPActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(diemCao_adapter);


    }
}
