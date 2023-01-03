package pawtropolis.map.domain;

import pawtropolis.animals.domain.Animal;
import pawtropolis.game.domain.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String nome;
    private Collection<Item> items;
    private Collection<Animal> animals;
    private Map<Direction, Room> adjacentRooms;

    public Room (String nome){
        this.nome = nome;
        this.items = null;
        this.animals = null;
        this.adjacentRooms = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    public Map<Direction, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<Direction, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }
}
