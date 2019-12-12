package com.example.thietkegiaodienapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.thietkegiaodienapplication.activity.ChoiMoi2Activity;
import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO  {
    private UserDatabase userDatabase;
     private  SQLiteDatabase db;
    public UserDAO(Context context) {
        userDatabase = new UserDatabase(context);
    }
    public String TABLE = "user";
    public String NAME = "name" ;
    public String PASS = "pass" ;
    public String DANHHIEU = "danhdieu" ;
    public String DIEM = "diem" ;
    public String LEVER = "lever";




    public List<User> truyxuat() {
        List<User> class_userList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();

        String select = "SELECT * FROM " + TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                User class_user = new User();

                class_user.name = cursor.getString(0);
                class_user.pass = cursor.getString(1);
                class_user.danhhieu = cursor.getString(2);
                class_user.diem = cursor.getInt(3);
                class_user.lever = cursor.getInt(4);
                class_userList.add(class_user);

            } while (cursor.moveToNext());
            cursor.close();
        }
        sqLiteDatabase.close();
        return class_userList;
    }

    public long insert(User user){

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(NAME,user.name);
        contentValues.put(PASS,user.pass);
        contentValues.put(DANHHIEU,user.danhhieu);
        contentValues.put(DIEM,user.diem);
        contentValues.put(LEVER,user.lever);
        long result = sqLiteDatabase.insert(TABLE,null,contentValues);

        sqLiteDatabase.close();
        return result;
    }

    public long delete(String name) {
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        long re = sqLiteDatabase.delete(TABLE, NAME + "=?", new String[]{name});
        sqLiteDatabase.close();
        return re;
    }

    public boolean isLogin(User user) {
        String sqlSelect = "select name, pass from user " +
                "where name=? and pass=?";
        db = userDatabase.getReadableDatabase();
        String name = user.getName();
        String pass = user.getPass();
        Cursor cursor = db.rawQuery(sqlSelect,new String[]{name, pass});
        if (cursor.moveToFirst()) {
            return true;
        }

        return false;
    }
    public long update(User user){

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(NAME,user.name);
        contentValues.put(PASS,user.pass);
        contentValues.put(DANHHIEU,user.danhhieu);
        contentValues.put(DIEM,user.diem);
        contentValues.put(LEVER,user.lever);
        long result = sqLiteDatabase.update(TABLE,contentValues,NAME + "=?", new String[]{user.name});
        sqLiteDatabase.close();
        return result;
    }

    }
