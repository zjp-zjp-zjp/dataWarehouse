package com.example.datawarehouse.entity;

public class Cooperate {
    private String rol1;
    private String rol2;
    private int count;

    public Cooperate(String rol1, String rol2, int count) {
        this.rol1 = rol1;
        this.rol2 = rol2;
        this.count = count;
    }

    public String getRol1() {
        return rol1;
    }

    public void setRol1(String rol1) {
        this.rol1 = rol1;
    }

    public String getRol2() {
        return rol2;
    }

    public void setRol2(String rol2) {
        this.rol2 = rol2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cooperate{" +
                "rol1='" + rol1 + '\'' +
                ", rol2='" + rol2 + '\'' +
                ", count=" + count +
                '}';
    }
}
