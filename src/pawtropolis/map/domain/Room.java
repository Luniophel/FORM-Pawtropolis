package pawtropolis.map.domain;

import pawtropolis.animals.domain.Animal;
import pawtropolis.game.domain.Item;

import java.util.Collection;
import java.util.Map;

public class Room {

    private String name;
    private Collection<Item> items = null;
    private Collection<Animal> animals;
    private Map<Direction, Room> adjacentRooms;

    public Room(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }


    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    public void setAdjacentRooms(Map<Direction, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    public String getName() {
        return name;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public Map<Direction, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

}
