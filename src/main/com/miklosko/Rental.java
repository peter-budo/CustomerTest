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

    public double charge(){
        return tape.charge(daysRented);
    }

    public int frequentRenterPoints() {
        return tape.movie().frequentRenterPoints(daysRented);
    }

    public String getTitle() {
        return tape.getTitle();
    }
}
