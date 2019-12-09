package com.example.thietkegiaodienapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thietkegiaodienapplication.adapter.UserAdapter;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class LisUserActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<User> users ;
UserDAO userDAO;
UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listuser);
        recyclerView=findViewById(R.id.recyclerview);
        users=new ArrayList<>();
        userDAO=new UserDAO(this);

        users=userDAO.truyxuat();
        userAdapter=new UserAdapter(users,LisUserActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);



    }
}
