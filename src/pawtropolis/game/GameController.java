package pawtropolis.game;

import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Action;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

public class GameController {

    //TODO Inserisci singleton appena MapController è implementato
    private MapController mapController;
    private Player player;



    public GameController(Player player) {
        this.mapController = new MapController();
        this.player = player;
    }

    public void runGame() {

        Room currentRoom = mapController.getCurrentRoom();
        boolean gameEnded = false;

        String input;
        String[] command;

        while(!gameEnded) {

            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            //Command commmand = CommandSelector.select(input);
            //command.execute();
            command = input.split(" ", 2);
            switch (Action.valueOf(command[0])) {
                case LOOK -> currentRoom.showInfo();
                case BAG -> player.lookIntoBag();
                case GO -> {
                    Direction direction = Direction.dir(command[1]);
                    if(direction == Direction.INVALID) {
                        System.out.println("Invalid direction");
                        break;
                    }
                    Room targetRoom = currentRoom.getRoomAtDirection(direction);
                    if (targetRoom == null) {
                        System.out.println("There is no room at " + direction);

                    } else {
                        currentRoom = targetRoom;
                        currentRoom.showInfo();
                    }
                }

                case GET -> {
                    String itemName = InputController.joinCommand(command, 1);
                    Item itemToGet = currentRoom.getItemByName(itemName);
                    if (itemToGet == null) {
                        System.out.println("There is no " + itemName + " in the room");
                    }
                    else{
                        if (player.addItemToBag(itemToGet)){
                            currentRoom.removeItem(itemToGet);
                            System.out.println("You got the " + itemName + "!");
                            System.out.println("You can't get the " + itemName);
                        }
                        else{
                            System.out.println("There is not enough space in the bag");
                        }
                    }
                }
                case DROP -> {
                    String itemName = InputController.joinCommand(command, 1);
                    Item itemToDrop = player.getItemByName(itemName);
                    if (itemToDrop == null) {
                        System.out.println("You can't drop the " + itemName + ":\nThere is no such item in the bag");
                    } else {
                        player.removeItemFromBag(itemToDrop);
                        currentRoom.addItem(itemToDrop);
                        System.out.println("You dropped the " + itemName + "!");
                    }
                }
                case EXIT -> {
                    if (input.equalsIgnoreCase("EXIT")) {
                        gameEnded = true;
                    } else {
                        System.out.println("Unknown command");
                    }
                }
                default -> System.out.println("Unknown command");
            }

        }
    }

}
