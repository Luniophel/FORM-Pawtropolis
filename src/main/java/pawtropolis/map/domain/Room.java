package main.java.pawtropolis.map.domain;

import main.java.pawtropolis.animal.domain.Animal;
import main.java.pawtropolis.game.domain.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class Room {

    private String name;
    private Collection<Item> items;
    private Collection<Animal> animals;
    private Map<Direction, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }

    //METHODS

    public void showInfo(){
        System.out.println("You're in " + name);
        adjacentRooms.forEach((k, v) -> System.out.println((k + ":" + v.getName())));
        if (items.isEmpty()){
            System.out.println("\nIn this room there are no items.");
        }else{
            System.out.println("\nIn this room there are the following items:");
            items.forEach( item -> System.out.println(" # " + item.getName()) );
        }
    }

    public void linkRoom(Room room, Direction direction){
        if(adjacentRooms.put(direction, room) == null){
            System.out.println("Successfully linked " + name + " with " + room.getName());
        } else {
            System.out.println("There is already a linked room, unlink it first!");
        }
    }

    public void unlinkRoom(Direction direction){
        if(adjacentRooms.remove(direction) != null){
            System.out.println("Successfully unlinked " + name + " from the room at " + direction);
        } else {
            System.out.println("There isn't a room to unlink on that direction.");
        }
    }

    public Room getRoomAtDirection(Direction direction){
        return adjacentRooms.get(direction);
    }

    public Item getItem(String itemName){
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny()
                .orElse(null);
    }

    public boolean removeItem(Item item){
        return items.remove(item);
    }

    public void addItem(Item item){
        items.add(item);
    }

    //GETTER & SETTER

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
