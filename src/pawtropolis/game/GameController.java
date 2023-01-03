package pawtropolis.game;

import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import static pawtropolis.map.domain.Direction.*;

public class GameController {

    private final Room entry;
    private final Player player;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
    }

    public void lookAround(Room room){
        System.out.println("You're in " + room.getName());
        room.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
    }

    public Room moveToAnotherRoom(Room room, Direction direction){
        System.out.println("You want to go to the " + direction);
        return room.getAdiacentRooms().get(direction);
    }

    public void runGame() {
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString();

            switch (input){

                case "look":
                    lookAround(currentRoom);
                    break;

                case "go north":
                    currentRoom = moveToAnotherRoom(currentRoom, NORTH);
                    break;

                case "go east":
                    currentRoom = moveToAnotherRoom(currentRoom, EAST);
                    break;

                case "go south":
                    currentRoom = moveToAnotherRoom(currentRoom, SOUTH);
                    break;

                case "go west":
                    currentRoom = moveToAnotherRoom(currentRoom, WEST);
                    break;

                default:
                    System.out.println("Unknown command... try again.");

            }
        }
    }
}
