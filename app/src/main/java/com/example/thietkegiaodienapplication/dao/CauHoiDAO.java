package com.example.thietkegiaodienapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thietkegiaodienapplication.database.UserDatabase;
import com.example.thietkegiaodienapplication.model.CauHoi;

import java.util.ArrayList;
import java.util.List;

public class CauHoiDAO {
    UserDatabase userDatabase;

    public CauHoiDAO(Context context) {
       userDatabase=new UserDatabase(context);
    }
    public String TABLE_CAUHOI = "cauhoi";
    public String CAUHOI = "cauhoi" ;
    public String DAPAN_A = "a" ;
    public String DAPAN_B = "b" ;
    public String DAPAN_C = "c" ;
    public String DAPAN_D = "d";
    public String CAUTRALOI = "cautraloidung";

    public List<CauHoi> getAll(){
        List<CauHoi> qlCauhoiList=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=userDatabase.getReadableDatabase();

        String SQL="SELECT * FROM "+ TABLE_CAUHOI;

        Cursor cursor=sqLiteDatabase.rawQuery(SQL, null);

        if(cursor !=null){
            if(cursor.getCount()>0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    CauHoi cauHoi=new CauHoi();


                    cauHoi.setCauhoi(cursor.getString(cursor.getColumnIndex(CAUHOI)).trim());
                    cauHoi.setDapan_a(cursor.getString(cursor.getColumnIndex(DAPAN_A)));
                    cauHoi.setDapan_b(cursor.getString(cursor.getColumnIndex(DAPAN_B)));
                    cauHoi.setDapan_c(cursor.getString(cursor.getColumnIndex(DAPAN_C)));
                    cauHoi.setDapan_d(cursor.getString(cursor.getColumnIndex(DAPAN_D)));
                    cauHoi.setCautraloidung(cursor.getString(cursor.getColumnIndex(CAUTRALOI)));

                    qlCauhoiList.add(cauHoi);
                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return qlCauhoiList;
    }
}
