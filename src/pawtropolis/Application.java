package pawtropolis;
import pawtropolis.map.domain.Directions;

import pawtropolis.animals.ZooController;
import pawtropolis.animals.domain.*;
import pawtropolis.map.domain.Room;

import java.time.LocalDate;
import java.util.HashMap;

public class Application {

    public static void main(String[] args) {

        Room room01 = new Room("room01");
        Room room02 = new Room("room02");
        Room room03 = new Room("room03");
        Room room04 = new Room("room04");
        Room room05 = new Room("room05");
        Room room06 = new Room("room06");

        HashMap<String, Room> adiacentRooms01 = new HashMap<>();
        adiacentRooms01.put("SUD", room03);
        adiacentRooms01.put("EST", room02);
        room01.setAdiacentRooms(adiacentRooms01);


        HashMap<String, Room> adiacentRooms02 = new HashMap<>();
        adiacentRooms02.put("SUD", room01);
        room02.setAdiacentRooms(adiacentRooms02);

        HashMap<String, Room> adiancentRooms03 = new HashMap<>();
        adiancentRooms03.put("EST", room01);
        room03.setAdiacentRooms(adiancentRooms03);

        HashMap<String, Room> adiacentRooms04 = new HashMap<>();
        adiacentRooms04.put("NORD", room05);
        adiacentRooms04.put("NORD", room01);
        adiacentRooms04.put("OVEST", room03);
        adiacentRooms04.put("EST", room06);
        room04.setAdiacentRooms(adiacentRooms04);

        //room05.setAdiacentRooms("OVEST",room04);

        //room06.setAdiacentRooms("NORD",room04);


        System.out.println("Room04 è collegata a NORD alla stanza: " + room04.getAdiacentRooms().get("NORD").getName());
    }
}