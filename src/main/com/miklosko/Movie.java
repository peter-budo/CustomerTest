package com.miklosko;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    private String name;
    private Price price;

    public Movie(String name, int priceCode) {
        this.name = name;
        setPriceCode(priceCode);
    }

    public void setPriceCode(int arg){
        switch(arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
        }
    }

    public String getTitle(){
        return name;
    }

    public double charge(int daysRented) {
        return price.charge(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return price.frequentRenterPoints(daysRented);
    }
}
