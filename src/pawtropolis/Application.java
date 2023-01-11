package pawtropolis;

import pawtropolis.game.GameController;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import static pawtropolis.map.domain.Direction.*;

public class Application {

    public static void main(String[] args) {

        Room room01 = new Room("room01");
        Room room02 = new Room("room02");
        Room room03 = new Room("room03");
        Room room04 = new Room("room04");
        Room room05 = new Room("room05");
        Room room06 = new Room("room06");

        Item item01 = new Item("Bread", "lorem ipsum", 1);
        Item item02 = new Item("Meat", "lorem ipsum", 1);
        Item item03 = new Item("Tomato sauce", "lorem ipsum", 1);
        Item item04 = new Item("Pizza with Pineapple", "Una cosa assai brutta", 1);



        Collection<Item> room01Items = new ArrayList<>();
        room01Items.add(item01);
        room01Items.add(item02);
        room01Items.add(item03);
        room01Items.add(item04);

        room01.setItems(room01Items);

        EnumMap<Direction, Room> adiacentRooms01 = new EnumMap<>(Direction.class);
        adiacentRooms01.put(SOUTH, room03);
        adiacentRooms01.put(EAST, room02);
        adiacentRooms01.put(NORTH, room04);

        room01.setAdjacentRooms(adiacentRooms01);

        EnumMap<Direction, Room> adiacentRooms02 = new EnumMap<>(Direction.class);
        adiacentRooms02.put(SOUTH, room01);
        room02.setAdjacentRooms(adiacentRooms02);

        EnumMap<Direction, Room> adiancentRooms03 = new EnumMap<>(Direction.class);
        adiancentRooms03.put(EAST, room01);
        room03.setAdjacentRooms(adiancentRooms03);

        EnumMap<Direction, Room> adiacentRooms04 = new EnumMap<>(Direction.class);
        adiacentRooms04.put(NORTH, room01);
        adiacentRooms04.put(WEST, room03);
        adiacentRooms04.put(EAST, room06);
        room04.setAdjacentRooms(adiacentRooms04);

        GameController gc = new GameController(room01, new Player("player01"));
        gc.runGame();

     }
}