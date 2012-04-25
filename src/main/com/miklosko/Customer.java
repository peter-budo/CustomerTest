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
                double thisAmount = 0;
                Rental each = (Rental) rentals.nextElement();

                //determine amounts for each line
                switch (each.tape().movie().priceCode()) {
                    case Movie.REGULAR:
                        thisAmount += 2;
                        if (each.daysRented() > 2)
                            thisAmount += (each.daysRented() - 2) * 1.5;
                        break;
                    case Movie.NEW_RELEASE:
                        thisAmount += each.daysRented() * 3;
                        break;
                    case Movie.CHILDRENS:
                        thisAmount += 1.5;
                        if (each.daysRented() > 3)
                            thisAmount += (each.daysRented() - 3) * 1.5;
                        break;

                }
                totalAmount += thisAmount;

                // add frequent renter points
                frequentRenterPoints ++;
                // add bonus for a two day new release rental
                if ((each.tape().movie().priceCode() == Movie.NEW_RELEASE) && each.daysRented() > 1) frequentRenterPoints ++;

                //show figures for this rental
                result += "\t" + each.tape().movie().name()+ "\t" + String.valueOf(thisAmount) + "\n";
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
}
	