package pawtropolis.animal.domain;

import java.time.LocalDate;

public class Lion extends AnimalWithTail{
    public Lion(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double tailLenght) {
        super(name, favoriteFood, age, joinDate, weight, height, tailLenght);
    }
}
