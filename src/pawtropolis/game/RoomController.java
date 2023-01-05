package pawtropolis.game;

import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class RoomController {

    public Item getItem(Room room, Item item){
        for (Item roomItem : room.getItems()) {
            return item.getName().equalsIgnoreCase(roomItem.getName()));
            }
        }
        return null;
    }

    public boolean removeItemfromRoom (Room room, Item item){
        room.getItems().remove(item);
    }

    public void  lookAround(Room room){
        System.out.println("You're in " + room.getName());
        room.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
    }

    public Room GetAdiacentRoom(Room room, String direction) {
        return room.getAdiacentRooms().get(Direction.valueOf(direction));
    }

}
