package com.example.thietkegiaodienapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.NhanVat;
import com.example.thietkegiaodienapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class NhanVatDAO {
    private UserDatabase userDatabase;
    private SQLiteDatabase db;
    public NhanVatDAO(Context context) {
        userDatabase = new UserDatabase(context);
    }
    public String TABLE_NV = "bangnhanvat";
    public String NAME_NV = "namenv" ;
    public String DIEM = "diem" ;

    public List<NhanVat> truyxuatnv() {
        List<NhanVat> nhanVats = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();

        String select = "SELECT * FROM bangnhanvat ORDER BY diem DESC";

        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                NhanVat nhanVat = new NhanVat();
             nhanVat.namenv=cursor.getString(0);
             nhanVat.diem=cursor.getInt(1);

                nhanVats.add(nhanVat);

            } while (cursor.moveToNext());
            cursor.close();
        }
        sqLiteDatabase.close();
        return nhanVats;
    }


    public long insert(NhanVat nhanVat){

        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(NAME_NV,nhanVat.namenv);
        contentValues.put(DIEM,nhanVat.diem);
        long result = sqLiteDatabase.insert(TABLE_NV,null,contentValues);

        sqLiteDatabase.close();
        return result;
    }
}
