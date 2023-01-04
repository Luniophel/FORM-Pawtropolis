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

    public void runGame() {
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString();


            if (input.equals("look"))
                currentRoom.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
                else if (Pattern.matches("go [a-zA-Z]{3,5}?",input)){
                    if(InputController.isValidDirection(input.substring(3))){
                        System.out.println("Direzione esatta");
                    }
                    else{
                        System.out.println("Direzione errata");
                    }
                }
            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }
}
