package com.miklosko;

public class NewReleasePrice extends Price {
    @Override
    double charge(int daysRented) {
        return daysRented * 3;
    }

    public int frequentRenterPoints(int daysRented){
        return daysRented> 1 ? 2: 1;
    }
}
