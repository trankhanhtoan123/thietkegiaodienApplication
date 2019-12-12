package com.example.thietkegiaodienapplication.model;

import android.widget.TextView;

public class NhanVat {
    public String namenv;
    public int diem;


    public NhanVat() {
    }

    public NhanVat(String namenv, int diem, String danhhieu, int lever) {
        this.namenv = namenv;
        this.diem = diem;

    }

    public String getNamenv() {
        return namenv;
    }

    public void setNamenv(String namenv) {
        this.namenv = namenv;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
