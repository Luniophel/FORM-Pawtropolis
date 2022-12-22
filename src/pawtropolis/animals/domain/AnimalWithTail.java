package pawtropolis.animals.domain;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    private double tailLenght;

    protected AnimalWithTail(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double tailLenght) {
        super(name, favoriteFood, age, joinDate, weight, height);
        this.tailLenght = tailLenght;
    }

    public double getTailLenght() {
        return tailLenght;
    }

    public void setTailLenght(double tailLenght) {
        this.tailLenght = tailLenght;
    }
}
