package main.java.pawtropolis.animal.domain;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal {

    private double wingspan;

    protected AnimalWithWings(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, joinDate, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
}
