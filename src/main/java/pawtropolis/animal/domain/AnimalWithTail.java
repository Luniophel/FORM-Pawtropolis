package main.java.pawtropolis.animal.domain;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    private double tailLength;

    protected AnimalWithTail(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double tailLenght) {
        super(name, favoriteFood, age, joinDate, weight, height);
        this.tailLength = tailLenght;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
}
