package com.miklosko;

import java.util.Enumeration;
import java.util.Vector;

class Customer extends DomainObject
{
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + name() + "\n";
        try {
            while (rentals.hasMoreElements()) {

                Rental rental = (Rental) rentals.nextElement();
                totalAmount += rental.charge();

                frequentRenterPoints += frequentRenterPointsFor(rental);

                //show figures for this rental
                result += "\t" + rental.tape().movie().name()+ "\t" + String.valueOf(rental.charge()) + "\n";
            }
        } catch (Throwable t) {
            System.out.println("Unexpected exception " + t);
        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }

    public String name() {
        return _name;
    }

    public void addRental(Rental rental){
        _rentals.add(rental);
    }

    private int frequentRenterPointsFor(Rental rental){
        if ((rental.tape().movie().priceCode() == Movie.NEW_RELEASE) && rental.daysRented() > 1)
            return 2;
        else
            return 1;
    }
}
	