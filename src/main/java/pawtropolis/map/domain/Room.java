package pawtropolis.map.domain;

import lombok.*;

import pawtropolis.game.domain.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinTable(
            name = "map",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private GameMap gameMap;

    @OneToMany(mappedBy = "room")
    private final Collection<Item> items = new ArrayList<>();

    @Getter
    @ManyToMany
    @JoinTable(name="room_adjacency",
            joinColumns = {
                    @JoinColumn(name = "room_a_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "room_b_id", referencedColumnName = "id")
            })
    @MapKeyEnumerated(EnumType.STRING)
    private final Map<Direction, Room> adjacentRooms = new EnumMap<>(Direction.class);

    public Room(String name) {
        this.name = name;
    }

    public String showInfo(){
        String roomInfo =
                "You're in " + name + "room.\n"                                +
                "You look around:\n\n"                                         +
                listAllAdjacentRooms() + "\n\n" + listAllItemsInRooms() + "\n" ;
        System.out.println(roomInfo);
        return roomInfo;
    }

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

}
