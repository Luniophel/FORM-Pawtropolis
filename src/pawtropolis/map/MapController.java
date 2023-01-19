package pawtropolis.map;

import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class MapController {
    private Room currentRoom;

    public MapController(){
        currentRoom = createMap();
    }

    private Room createMap(){
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

    private void linkRooms(Room a, Room b, Direction dirA, Direction dirB){
        a.linkRoom(b, dirA);
        b.linkRoom(a, dirB);
    }

    public void changeRoom(Direction direction){
        currentRoom = currentRoom.getRoomAtDirection(direction);
    }

    public boolean isRoomAtDirection(Direction direction){
        return currentRoom.getAdjacentRooms().containsKey(direction);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void showCurrentRoomInfo(){
        currentRoom.showInfo();
    }

    public Item getItemByItemName(String itemName){
        return currentRoom.getItem(itemName);
    }

    public boolean removeItem(Item item){
        return currentRoom.removeItem(item);
    }
}
