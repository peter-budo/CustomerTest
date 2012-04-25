package com.miklosko;

public class Tape {

    private Movie movie;
    private long id;

    public Tape(Movie movie, long id) {
        this.movie = movie;
        this.id = id;
    }

    public Movie movie(){
        return movie;
    }

    public double charge(int daysRented) {
        return movie.charge(daysRented);
    }

    public String getTitle() {
        return movie.getTitle();
    }
}
