package com.example.thietkegiaodienapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.thietkegiaodienapplication.LisUserActivity;
import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.User;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

public class Loginctivity extends AppCompatActivity {
    Button btndangnhap, btndangky;
    List<User> users;
    UserDAO userDAO;

    ImageView imgtatloa, imgmoloa;
    ViewFlipper viewFlipper;
    LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        UserDatabase userDatabase = new UserDatabase(this);
        userDatabase.createDataBase();
        btndangnhap = findViewById(R.id.btndangnhap);
        btndangky = findViewById(R.id.btndangky);
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogdangky();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginctivity.this, LisUserActivity.class);
                startActivity(intent);
            }
        });
        userDAO = new UserDAO(this);
        users = new ArrayList<>();
        imgtatloa = findViewById(R.id.imgtatloa);
        imgmoloa = (ImageView) findViewById(R.id.imgmoloa);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        final MediaPlayer mediaPlayer = MediaPlayer.create(Loginctivity.this, R.raw.nhacchuong);
        CallbackManager callbackManager = CallbackManager.Factory.create(); //gọi đến fb
        loginButton = (LoginButton) findViewById(R.id.login_btn);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        imgmoloa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                mediaPlayer.pause();

            }
        });
        imgtatloa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                mediaPlayer.start();
                Toast.makeText(Loginctivity.this, "Phát nhạc", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void dialogdangky() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_dangky);

        final EditText edtname = (EditText) dialog.findViewById(R.id.edtname);
        final EditText edtpass = (EditText) dialog.findViewById(R.id.edtpass);
        final EditText edtrepass = (EditText) dialog.findViewById(R.id.edtrepass);
        Button btndangky = (Button) dialog.findViewById(R.id.btndangkylogin);
        Button btnxoa = (Button) dialog.findViewById(R.id.btnxoalogin);
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtname.setText("");
                edtpass.setText("");
                edtrepass.setText("");
            }
        });

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String pass = edtpass.getText().toString();
                String repass = edtrepass.getText().toString();
                if (name.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                    Toast.makeText(Loginctivity.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(repass)) {
                    Toast.makeText(Loginctivity.this, "Mật khẩu nhập lại sai", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(name, pass);
                    user.name = name;
                    user.pass = pass;
                    users.add(user);

                    long re = userDAO.insert(user);
                    if (re > 0) {
                        Toast.makeText(Loginctivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        edtname.setText("");
                        edtpass.setText("");
                        edtrepass.setText("");
                        dialog.dismiss();
                    } else {
                        Toast.makeText(Loginctivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.show();
    }
}
