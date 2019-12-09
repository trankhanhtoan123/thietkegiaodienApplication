package com.example.thietkegiaodienapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thietkegiaodienapplication.DoimatkhauActivity;
import com.example.thietkegiaodienapplication.LisUserActivity;
import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.UserActivity;
import com.example.thietkegiaodienapplication.database.UserDatabase;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.activity_main);



       toolbar=findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId()== R.id.itemdoikhatkhau){
            Intent intent = new Intent(MainActivity.this, DoimatkhauActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()== R.id.itemtaikhoan){
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.itemdangxuat){
            Intent intent = new Intent(MainActivity.this, LisUserActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
