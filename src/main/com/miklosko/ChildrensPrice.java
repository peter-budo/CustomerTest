package com.miklosko;

public class ChildrensPrice extends Price {
    @Override
    double charge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
