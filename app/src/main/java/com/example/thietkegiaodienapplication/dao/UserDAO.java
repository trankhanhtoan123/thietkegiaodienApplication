package com.example.thietkegiaodienapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO  {
    UserDatabase userDatabase;
     SQLiteDatabase db;
    public UserDAO(Context context) {
        userDatabase = new UserDatabase(context);
    }
    private String TABLE_NAME = "user";
    public String NAME = "name" ;
    public String PASS= "pass" ;
    public String DANHHIEU = "danhhieu" ;
    public String TAISAN= "taisan" ;
    public String LEVER= "lever" ;



    public List<User> truyxuat(){
        List<User> users=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=userDatabase.getReadableDatabase();

        String SQL="SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if(cursor !=null){
            if(cursor.getCount()>0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    User user=new User();

                    user.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                    user.setPass(cursor.getString(cursor.getColumnIndex(PASS)));
                    user.setDanhhieu(cursor.getString(cursor.getColumnIndex(DANHHIEU)));
                    user.setTaisan(Integer.parseInt(cursor.getString(cursor.getColumnIndex(TAISAN))));
                    user.setLever(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LEVER))));


                    users.add(user);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return users;
    }

    public long insert(User user){

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(NAME,user.getName());
        contentValues.put(PASS,user.getPass());
        contentValues.put(DANHHIEU,user.getDanhhieu());
        contentValues.put(TAISAN,user.getTaisan());
        contentValues.put(LEVER,user.getLever());
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        sqLiteDatabase.close();
        return result;
    }

    public long delete(String name) {
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        long re = sqLiteDatabase.delete(TABLE_NAME, NAME + "=?", new String[]{name});
        sqLiteDatabase.close();
        return re;
    }
    public boolean isLogin(User user) {
        String sqlSelect = " select " + NAME + " , " + PASS + " from " + TABLE_NAME + " WHERE " + NAME + " =? and " + PASS + " =? ";
        db = userDatabase.getReadableDatabase();
        String name = user.getName();
        String pass = user.getPass();
        Cursor cursor = db.rawQuery(sqlSelect,new String[]{name, pass});
        if (cursor.moveToFirst()) {
            return true;
        }

        return false;
    }
}
