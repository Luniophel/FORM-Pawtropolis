package pawtropolis.game;

import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Room;

import pawtropolis.map.domain.Direction;
import static pawtropolis.map.domain.Direction.*;

import pawtropolis.game.domain.Action;
import static pawtropolis.game.domain.Action.*;

public class GameController {

    private final Room entry;
    private final Player player;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
    }

    public void runGame() {
        Room currentRoom = entry;

        PlayerController playerController = new PlayerController(player);

        boolean gameEnded = false;

        String input;
        String[] command;

        while(!gameEnded) {

            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            command = input.split(" ", 2);

            //LOOK COMMAND
            if (input.equalsIgnoreCase("LOOK")) {
                playerController.lookAround(currentRoom);
                continue;
            }

            //BAG COMMAND
            if (input.equalsIgnoreCase("BAG")) {
                playerController.showBagContent();
                continue;
            }

            //GO COMMAND
            if ( (command.length>1) && (command[0].equalsIgnoreCase("GO")) ) {
                if (InputController.isValidDirection(command[1])) {
                    Room targetRoom = currentRoom.getAdiacentRooms().get(Direction.valueOf(command[1]));
                    if (targetRoom != null) {
                        currentRoom = targetRoom;
                        playerController.lookAround(currentRoom);
                        continue;
                    }
                    else{
                        System.out.println("There is no room at " + command[1]);
                        continue;
                    }
                }

                System.out.println("Unrecognized command");
            }

            //GET COMMAND
            /*
            if ( (command.length>1) && (command[1].equalsIgnoreCase("GET")) {
                String itemName = InputController.joinCommand(command,1);
                Item itemToGet = roomController.getItem(itemToGet);
                if (itemToGet != null){
                    if (playerController.isThereEnoughSlotsInBag(itemToGet)){
                        playerController.addItemtoBag(itemToGet);
                        roomController.removeItemfromRoom(itemToGet)
                        continue;
                    }
                    else{
                        System.out.printl("You can't get the " + itemName );
                        System.out.println("There is not enough space in the bag");
                        continue;
                    }
                    System.out.println("There is no " + itemName + " in the room");
                }
            }
            */

            //EXIT COMMAND
            if (input.equalsIgnoreCase("EXIT")) {
                gameEnded = true;
            }
        }
    }
}
