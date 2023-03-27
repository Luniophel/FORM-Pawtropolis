package pawtropolis.map;

import lombok.Getter;
import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class MapProvider {

    @Getter
    private static final Room MAP01 = createMap();

    private MapProvider(){
        throw new IllegalStateException("This map should not be instantiated");
    }

    private static Room createMap(){
        Room entry          = new Room("Entry");
        Room hall           = new Room("Main Hall");
        linkRooms(entry, hall, Direction.NORTH, Direction.SOUTH);
        entry.addItem(new Item("item", "Lorem Ipsum", 2));

        Room library        = new Room("Library");
        linkRooms(hall, library, Direction.EAST, Direction.WEST);
        library.addItem(new Item("Old Book", "Nice weapon, better than my Warhammer+3", 2));

        Room cafeteria      = new Room("Cafeteria");
        linkRooms(hall, cafeteria, Direction.WEST, Direction.EAST);
        cafeteria.addItem(new Item("coffee", "got a coffee, but didn't splash..", 1));

        Room waitingRoom    = new Room("Waiting Room");
        linkRooms(hall, waitingRoom, Direction.NORTH, Direction.SOUTH);

        Room bossOffice     = new Room("Boss Office");
        linkRooms(waitingRoom, bossOffice, Direction.NORTH, Direction.SOUTH);
        bossOffice.addItem(new Item("Floppy Disk", "A floppy disk? Really? dude wtf?", 1));

        return entry;
    }

    private static void linkRooms(Room a, Room b, Direction dirA, Direction dirB){
        a.linkRoom(b, dirA);
        b.linkRoom(a, dirB);
    }

}
