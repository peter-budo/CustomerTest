package com.miklosko;

abstract class Price {

    abstract double charge(int daysRented);

    int frequentRenterPoints(int daysRented){
        return 1;
    }
}
