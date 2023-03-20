package pawtropolis.map;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

@Component
public class MapController {

    @Getter
    private Room currentRoom;

    @Autowired
    private MapController(){
        this.currentRoom = MapProvider.getMAP01();
    }

    public void changeRoom(Direction direction){
        currentRoom = currentRoom.getRoomAtDirection(direction);
    }

    public boolean isRoomAtDirection(Direction direction){
        return currentRoom.getAdjacentRooms().containsKey(direction);
    }

    public void showCurrentRoomInfo(){
        currentRoom.showInfo();
    }

    public Item getItemByItemName(String itemName){
        return currentRoom.getItem(itemName);
    }

    public boolean removeItemFromCurrentRoom(Item item){
        return currentRoom.removeItem(item);
    }

    public void addItemToCurrentRoom(Item itemToAdd){
        currentRoom.addItem(itemToAdd);
    }
}
