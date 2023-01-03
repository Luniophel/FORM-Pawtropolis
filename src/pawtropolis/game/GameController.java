package pawtropolis.game;

import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

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

            switch (input){
                case "look":
                    currentRoom.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
                    break;

                //case "go "

            }


            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }
}
