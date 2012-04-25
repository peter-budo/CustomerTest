package com.miklosko;

public class Movie {

    private int priceCode = 0;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    private String name;

    public Movie(String name, int priceCode) {
        this.name = name;
        this.priceCode = priceCode;
    }

    public int priceCode(){
        return priceCode;
    }

    public String name(){
        return name;
    }
}
