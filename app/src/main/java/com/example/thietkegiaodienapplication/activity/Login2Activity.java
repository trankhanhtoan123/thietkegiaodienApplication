package com.example.thietkegiaodienapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thietkegiaodienapplication.MainActivity;
import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.model.User;

public class Login2Activity extends AppCompatActivity {
    TextView textView;
    EditText edtpass;
    Button btnthoat,btndangnhap;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login2);
        textView = findViewById(R.id.tvname);
        edtpass=findViewById(R.id.edtpass1);
        btnthoat=findViewById(R.id.btnthoat);
        btndangnhap=findViewById(R.id.btndangnhap1);
        userDAO=new UserDAO(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String name = bundle.getString("NAME");
            textView.setText(name);
        }
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          userDAO=new UserDAO(Login2Activity.this);
                String pass = edtpass.getText().toString();
                String name = textView.getText().toString();
                User user = new User(name,pass);
         Boolean r= userDAO.isLogin(user);
         if(r){
             Toast.makeText(Login2Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
             Intent intent= new Intent(Login2Activity.this, MainActivity.class);
             startActivity(intent);
         }
         else {
             Toast.makeText(Login2Activity.this, "Thất bại", Toast.LENGTH_SHORT).show();
         }

            }
        });

    }
}
