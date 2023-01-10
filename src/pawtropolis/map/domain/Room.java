package pawtropolis.map.domain;

import pawtropolis.animals.domain.Animal;
import pawtropolis.game.domain.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String name;
    private Collection<Item> items = null;
    private Collection<Animal> animals;
    private Map<Direction, Room> adiacentRooms;

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

    public void setAdiacentRooms(Map<Direction, Room> adiacentRooms) {
        this.adiacentRooms = adiacentRooms;
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

    public Map<Direction, Room> getAdiacentRooms() {
        return adiacentRooms;
    }

    /*
     * Classe per rappresentare una stanza del gioco
     *
     */
}
