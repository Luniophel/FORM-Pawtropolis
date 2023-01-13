package pawtropolis.game;

import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class RoomController {

    public void showRoomInfo(Room room){
        System.out.println("You're in " + room.getName());
        room.getAdjacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
        if (room.getItems() != null){
            System.out.println("\nIn this room there are the following items:");
            room.getItems().forEach( item -> System.out.println(" # " + item.getName()) );
        }else{
            System.out.println("\nIn this room there are no items.");
        }
    }

    public Room getRoomIfPresent(Room currentRoom, Direction direction){
        return currentRoom.getAdjacentRooms().get(direction);
    }

    public Item getItemByNameFromRoom(Room room, String itemName){
        return room.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny()
                .orElse(null);
    }

    public void removeItemFromRoom(Room room, Item item){
        room.getItems().remove(item);
    }

    public void addItemToRoom (Room room, Item item){
        room.getItems().add(item);
    }
}
