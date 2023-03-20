package pawtropolis.map.domain;

import lombok.*;

import pawtropolis.animal.domain.Animal;
import pawtropolis.game.domain.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class Room {

    @NonNull
    @Getter
    @Setter
    private String name;

    private final Collection<Item> items;
    private final Collection<Animal> animals;

    @Getter
    private final Map<Direction, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }

    public String showInfo(){
        String roomInfo =
                "You're in " + name + "room.\n"                                +
                "You look around:\n\n"                                         +
                listAllAdjacentRooms() + "\n\n" + listAllItemsInRooms() + "\n" ;
        //TODO Togliere il print una volta aggiunta un'interfaccia grafica
        System.out.println(roomInfo);
        return roomInfo;
    }

    //TODO Valutare possibile implementazione di classe Utils che generalizza i metodi di listamento e stampa
    private String listAllAdjacentRooms (){
        return adjacentRooms.isEmpty()
            ? "You don't see any adjacent room here.\n"
            : "You see " + adjacentRooms.size() + " adjacent rooms:\n" +
            adjacentRooms.entrySet().stream()
             .map(entry -> " #" + entry.getKey().name() + ": " + entry.getValue().name)
             .collect(Collectors.joining(";\n"));
    }

    private String listAllItemsInRooms (){
        return items.isEmpty()
            ? "In this room there are no items.\n"
            : "In this room there are the following items:\n" +
            items.stream()
             .map(item -> " #" + item.getName())
             .collect(Collectors.joining(";\n"));
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

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
}
