package com.miklosko;

public class Rental {
    private Tape tape;
    private int daysRented = 0;

    public Rental(Tape tape, int daysRented) {
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public Tape tape() {
        return tape;
    }

    public int daysRented() {
        return daysRented;
    }

    public double charge(){
        double amount = 0;
        switch (tape().movie().priceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented() > 2)
                    amount += (daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (daysRented() > 3)
                    amount += (daysRented() - 3) * 1.5;
                break;

        }
        return amount;
    }
}
