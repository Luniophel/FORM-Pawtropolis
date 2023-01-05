package pawtropolis.game.domain;

import pawtropolis.map.domain.*;

public enum Action {
    GO,
    LOOK,
    BAG,
    GET,
    DROP;

    public Room changeRoom(Room currentRoom, Direction direction){
        return currentRoom.getAdiacentRooms().getOrDefault(direction, currentRoom);
    }
}
