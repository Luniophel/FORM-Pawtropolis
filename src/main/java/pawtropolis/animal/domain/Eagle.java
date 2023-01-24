package main.java.pawtropolis.animal.domain;

import java.time.LocalDate;

public class Eagle extends AnimalWithWings{
    public Eagle(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, joinDate, weight, height, wingspan);
    }
}
