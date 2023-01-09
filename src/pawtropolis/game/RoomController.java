package pawtropolis.game;

import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class RoomController {

    public void showRoomInfo(Room room){
        System.out.println("You're in " + room.getName());
        room.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
        System.out.println("\nIn this room there are the following items:");

        room.getItems().forEach(item -> System.out.println(" # " + item.getName()));


    }

    public Item getItemFromRoom(Room room, String itemName){
        for (Item roomItem : room.getItems()) {
            if(itemName.equalsIgnoreCase(roomItem.getName())){
                return roomItem;
            }
        }
        return null;
    }

    public void removeItemfromRoom (Room room, Item item){
        room.getItems().remove(item);
    }

    public Room GetAdiacentRoom(Room room, String direction) {
        return room.getAdiacentRooms().get(Direction.valueOf(direction));
    }

}
