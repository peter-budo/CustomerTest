package com.miklosko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Vector;

class Customer extends DomainObject {

    private static final Logger LOG = LoggerFactory.getLogger(Customer.class);
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + name() + "\n");
        try {
            while (rentals.hasMoreElements()) {

                Rental rental = (Rental) rentals.nextElement();
                result.append("\t" + rental.getTitle() + "\t" + String.valueOf(rental.charge()) + "\n");
            }
            result.append("Amount owed is " + String.valueOf(totalAmount()) + "\n");
            result.append("You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points");
        } catch (Throwable t) {
            LOG.error("Unexpected exception " + t);
        }

        return result.toString();

    }

    public String name() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    private int frequentRenterPointsFor(Rental rental) {
        return rental.frequentRenterPoints();
    }

    private double totalAmount() {
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            totalAmount += rental.charge();
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int points = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            points += frequentRenterPointsFor(rental);
        }
        return points;
    }
}
	