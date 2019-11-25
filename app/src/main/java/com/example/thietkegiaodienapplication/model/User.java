package com.example.thietkegiaodienapplication.model;

public class User {
    public String name,pass,namenv,danhhieu;
    public double taisan;
    public int lever;

    public User(String name, String pass, String namenv, String danhhieu, double taisan, int lever) {
        this.name = name;
        this.pass = pass;
        this.namenv = namenv;
        this.danhhieu = danhhieu;
        this.taisan = taisan;
        this.lever = lever;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNamenv() {
        return namenv;
    }

    public void setNamenv(String namenv) {
        this.namenv = namenv;
    }

    public String getDanhhieu() {
        return danhhieu;
    }

    public void setDanhhieu(String danhhieu) {
        this.danhhieu = danhhieu;
    }

    public double getTaisan() {
        return taisan;
    }

    public void setTaisan(double taisan) {
        this.taisan = taisan;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }
}
