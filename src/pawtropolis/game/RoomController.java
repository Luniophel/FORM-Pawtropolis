package pawtropolis.game;

import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class RoomController {

    /*
    public Item getItem(Room room, Item item){
        for (Item roomItem : room.getItems()) {
            return item.getName().equalsIgnoreCase(roomItem.getName());
            }
        }
    }
    */

    public void removeItemfromRoom (Room room, Item item){
        room.getItems().remove(item);
    }

    public Room GetAdiacentRoom(Room room, String direction) {
        return room.getAdiacentRooms().get(Direction.valueOf(direction));
    }

}
