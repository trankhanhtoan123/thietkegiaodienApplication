package com.example.thietkegiaodienapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.thietkegiaodienapplication.LisUserActivity;
import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.model.Check;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
Button btnchoi,btntop,btnintro;
public static List<Check> checks;
public static int cauhoi;
public static int diem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.activity_main);
     btnchoi=findViewById(R.id.btnchoi);
     btntop=findViewById(R.id.btntop);
     btnintro=findViewById(R.id.btnintro);
     checks=new ArrayList<>();
     btnchoi.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             diem=20;
             cauhoi=0;
             ChoiMoi2Activity.luotchoi=3;
             Intent intent = new Intent(MainActivity.this,ChoiMoi2Activity.class);
             startActivity(intent);
         }
     });
     btntop.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this,TOPActivity.class);
             startActivity(intent);
         }
     });
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
