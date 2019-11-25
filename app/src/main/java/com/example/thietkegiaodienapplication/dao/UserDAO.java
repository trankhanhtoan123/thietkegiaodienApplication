package com.example.thietkegiaodienapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.thietkegiaodienapplication.database.UserDatabase.DANHHIEU;
import static com.example.thietkegiaodienapplication.database.UserDatabase.LEVER;
import static com.example.thietkegiaodienapplication.database.UserDatabase.NAME;
import static com.example.thietkegiaodienapplication.database.UserDatabase.NAMENV;
import static com.example.thietkegiaodienapplication.database.UserDatabase.PASS;
import static com.example.thietkegiaodienapplication.database.UserDatabase.TABLE_NAME;
import static com.example.thietkegiaodienapplication.database.UserDatabase.TAISAN;


public class UserDAO {
    UserDatabase userDatabase;
    SQLiteDatabase db;

    public UserDAO(Context context) {
        userDatabase = new UserDatabase(context);
    }

    public long insertuser(User user) {
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, user.name);
        contentValues.put(PASS, user.pass);
        contentValues.put(NAMENV, user.namenv);
        contentValues.put(TAISAN, user.taisan);
        contentValues.put(DANHHIEU, user.danhhieu);
        contentValues.put(LEVER, user.lever);
        long re = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        return re;
    }

    public List<User> truyxuat() {
        List<User> class_userList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        String SELEC = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(SELEC, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.name = cursor.getString(0);
                user.pass = cursor.getString(1);
                user.namenv = cursor.getString(2);
                user.danhhieu = cursor.getString(3);
                user.taisan = cursor.getDouble(4);
                user.lever = cursor.getInt(5);
                class_userList.add(user);
            } while (cursor.moveToNext());

        }
        cursor.close();
        sqLiteDatabase.close();
        return class_userList;

    }

    public long delete(String name) {
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        long re = sqLiteDatabase.delete(TABLE_NAME, NAME + " =? ", new String[]{name});
        sqLiteDatabase.close();
        return re;
    }

    public boolean isLogin(User user) {
        String sqlSelect = " select " + NAME + " , " + PASS + " from " + TABLE_NAME + " WHERE " + NAME + " =? and " + PASS + " =? ";
        db = userDatabase.getReadableDatabase();
        String name = user.getName();
        String pass = user.getPass();
        Cursor cursor = db.rawQuery(sqlSelect, new String[]{name, pass});
        if (cursor.moveToFirst()) {
            return true;
        }

        return false;
    }
}
