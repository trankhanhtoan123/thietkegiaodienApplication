package com.example.thietkegiaodienapplication.model;

public class User {
    public String name,pass,danhhieu;
    public int diem;
    public int lever;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(int diem) {
        this.diem = diem;
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

    public String getDanhhieu() {
        return danhhieu;
    }

    public void setDanhhieu(String danhhieu) {
        this.danhhieu = danhhieu;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public User(String name, String pass, String danhhieu, int diem, int lever) {
        this.name = name;
        this.pass = pass;
        this.danhhieu = danhhieu;
        this.diem = diem;
        this.lever = lever;
    }

    public void danhhieu(User user){
        if(user.diem>5){

        }
    }
}
