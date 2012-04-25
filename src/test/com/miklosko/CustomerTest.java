package com.miklosko;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Movie children = new Movie("Ice Age", Movie.CHILDRENS);
    private Movie regular = new Movie("Sahara", Movie.REGULAR);
    private Movie newRelease = new Movie("Captain America - The First Avenger", Movie.NEW_RELEASE);
    private Tape tapeChildren = new Tape(children, 1);
    private Tape tapeRegular = new Tape(regular, 2);
    private Tape tapeNewRelease = new Tape(newRelease, 3);
    private Rental rentalChildren = new Rental(tapeChildren, 7);
    private Rental rentalRegular = new Rental(tapeRegular, 5);
    private Rental rentalNewRelease = new Rental(tapeNewRelease, 3);
    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer("Peter");
    }

    @After
    public void tearDown(){
        customer = null;
    }

    @Test
    public void singleRental(){
        customer.addRental(rentalChildren);
        assertEquals(expectedSingleRental(), customer.statement());
    }

    @Test
    public void allRentals(){
        customer.addRental(rentalChildren);
        customer.addRental(rentalRegular);
        customer.addRental(rentalNewRelease);
        assertEquals(expectedAllRentals(), customer.statement());
    }

    private String expectedSingleRental(){
        return new StringBuilder("Rental Record for " + customer.name() +"\n")
                .append("\t"+"Ice Age"+"\t"+singleRentalAmount()+"\n")
                .append("Amount owed is " + singleRentalAmount()+"\n")
                .append("You earned " + 1 + " frequent renter points")
                .toString();
    }

    private String expectedAllRentals(){
        return new StringBuilder("Rental Record for " + customer.name() +"\n")
                .append("\t"+"Ice Age"+"\t"+ iceAgeAmount()+"\n")
                .append("\t"+"Sahara"+"\t"+saharaAmount()+"\n")
                .append("\t"+"Captain America - The First Avenger"+"\t"+captainAmericaAmount()+"\n")
                .append("Amount owed is " + allRentalAmount()+"\n")
                .append("You earned " + 4 + " frequent renter points")
                .toString();
    }

    private double singleRentalAmount(){
        return iceAgeAmount();
    }

    private double iceAgeAmount(){
        return 1.5+((7-3)*1.5);
    }

    private double saharaAmount(){
        return  2+((5-2)*1.5);
    }

    private double captainAmericaAmount(){
        return 3*3;
    }

    private double allRentalAmount(){
        return iceAgeAmount()+saharaAmount()+captainAmericaAmount();
    }
}
