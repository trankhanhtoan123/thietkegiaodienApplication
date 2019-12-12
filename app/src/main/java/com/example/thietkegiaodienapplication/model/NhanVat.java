package com.example.thietkegiaodienapplication.model;

public class NhanVat {
    public String namenv;
    public int diem;
    public String danhhieu;
    public int lever;

    public NhanVat() {
    }

    public NhanVat(String namenv, int diem, String danhhieu, int lever) {
        this.namenv = namenv;
        this.diem = diem;
        this.danhhieu = danhhieu;
        this.lever = lever;
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

    public String getDanhhieu() {
        return danhhieu;
    }

    public void setDanhhieu(String danhhieu) {
        this.danhhieu = danhhieu;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }
}
