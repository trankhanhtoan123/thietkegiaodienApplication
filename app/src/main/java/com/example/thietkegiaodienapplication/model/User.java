package com.example.thietkegiaodienapplication.model;

public class User {
    public String name,pass,danhhieu;
    public double taisan;
    public int lever;

    public User() {
    }

    public User(String name, String pass) {
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
