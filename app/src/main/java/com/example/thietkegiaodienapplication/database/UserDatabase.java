package com.example.thietkegiaodienapplication.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user_manager";
    public static final String TABLE_NAME="manager";
    public static final String NAME="name";
    public static final String PASS="pass";
    public static final String NAMENV="namenv";
    public static final String DANHHIEU="danhhieu";
    public static final String TAISAN="taisan";
    public static final String LEVER="lever";
    public UserDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQuery= " CREATE TABLE " + TABLE_NAME + " ( " + NAME + " TEXT PRIMARY KEY , " + PASS + " TEXT , " + NAMENV + "  TEXT , " + DANHHIEU + " TEXT , " + TAISAN + "  DOUBLE , " + LEVER + " INT ) " ;
       db.execSQL(SQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
