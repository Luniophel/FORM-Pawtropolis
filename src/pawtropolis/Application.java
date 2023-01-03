package pawtropolis;

import pawtropolis.animals.ZooController;
import pawtropolis.animals.domain.*;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static pawtropolis.map.domain.Direction.EST;

public class Application {

    public static void main(String[] args) {

        Room room01 = new Room("room01");
        Room room02 = new Room("room02");
        Room room03 = new Room("room03");
        Room room04 = new Room("room04");
        Room room05 = new Room("room05");
        Room room06 = new Room("room06");

        HashMap<Direction, Room> adiacentRooms01 = new HashMap<>();
        adiacentRooms01.put(Direction.SOUTH, room03);
        adiacentRooms01.put(Direction.EST, room02);
        room01.setAdiacentRooms(adiacentRooms01);


        HashMap<Direction, Room> adiacentRooms02 = new HashMap<>();
        adiacentRooms02.put(Direction.SOUTH, room01);
        room02.setAdiacentRooms(adiacentRooms02);

        HashMap<Direction, Room> adiancentRooms03 = new HashMap<>();
        adiancentRooms03.put(Direction.EST, room01);
        room03.setAdiacentRooms(adiancentRooms03);

        HashMap<Direction, Room> adiacentRooms04 = new HashMap<>();
        adiacentRooms04.put(Direction.NORTH, room01);
        adiacentRooms04.put(Direction.WEST, room03);
        adiacentRooms04.put(Direction.EST, room06);
        room04.setAdiacentRooms(adiacentRooms04);

        //System.out.println("Room04 è collegata a NORD alla stanza: " + room04.getAdiacentRooms().get("NORD").getName());
        //System.out.println( adiacentRooms04.keySet().stream().collect(Collectors.toList())); //Vedo quali direzioni sono occupate
        
        adiacentRooms04.forEach((k, v) -> System.out.println((k + ":" + v.getName())));

    }
}