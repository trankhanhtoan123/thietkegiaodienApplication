package com.example.thietkegiaodienapplication.model;

public class CauHoi {
    public String Cauhoi,dapan_a,dapan_b,dapan_c,dapan_d,cautraloidung;

    public CauHoi(String cauhoi, String dapan_a, String dapan_b, String dapan_c, String dapan_d, String cautraloidung) {
        Cauhoi = cauhoi;
        this.dapan_a = dapan_a;
        this.dapan_b = dapan_b;
        this.dapan_c = dapan_c;
        this.dapan_d = dapan_d;
        this.cautraloidung = cautraloidung;
    }

    public CauHoi() {
    }

    public String getCauhoi() {
        return Cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        Cauhoi = cauhoi;
    }

    public String getDapan_a() {
        return dapan_a;
    }

    public void setDapan_a(String dapan_a) {
        this.dapan_a = dapan_a;
    }

    public String getDapan_b() {
        return dapan_b;
    }

    public void setDapan_b(String dapan_b) {
        this.dapan_b = dapan_b;
    }

    public String getDapan_c() {
        return dapan_c;
    }

    public void setDapan_c(String dapan_c) {
        this.dapan_c = dapan_c;
    }

    public String getDapan_d() {
        return dapan_d;
    }

    public void setDapan_d(String dapan_d) {
        this.dapan_d = dapan_d;
    }

    public String getCautraloidung() {
        return cautraloidung;
    }

    public void setCautraloidung(String cautraloidung) {
        this.cautraloidung = cautraloidung;
    }
}
