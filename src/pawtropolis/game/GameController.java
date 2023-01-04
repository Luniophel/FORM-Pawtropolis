package pawtropolis.game;

import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.util.regex.Pattern;

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

    public void runGame() {
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString().toUpperCase();


            if (input.equalsIgnoreCase("LOOK"))
                lookAround(currentRoom);
                else if (Pattern.matches("GO [a-zA-Z]{3,5}?",input)) {
                    String direction = input.substring(3);
                    if (InputController.isValidDirection(direction)) {
                        if (currentRoom.getAdiacentRooms().get(Direction.valueOf(direction)) == null) {
                            System.out.println("You can't go to " + direction + " direction");
                        }
                        else {
                            currentRoom = currentRoom.getAdiacentRooms().get(Direction.valueOf(direction));
                            lookAround(currentRoom);
                        }
                    }
                    else{System.out.println("Comando errato");}
                }
            if (input.equalsIgnoreCase("EXIT")) {
                gameEnded = true;
            }
        }
    }
}
