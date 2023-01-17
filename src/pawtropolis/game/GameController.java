package pawtropolis.game;

import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Action;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.util.List;

public class GameController {

    //TODO Inserisci singleton appena MapController è implementato
    private final Room entry;
    private final Player player;

   // private InputFormatter inputFormatter;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
     //   this.inputFormatter = new InputFormatter();

    }

    public void runGame() {

        Room currentRoom = entry;
        boolean gameEnded = false;

        String input;
        String[] command;

        while(!gameEnded) {

            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            List<String> tokens = InputController.makeTokens(input);
            Command command = CommandFactory.getCommandFromString(tokens.get(0));
            command.execute(tokens);

            //TODO il commento seguente è stato inserito solo per testare la classe Look (sottoclasse di Command)
            /*command = input.split(" ", 2);
             switch (Action.valueOf(command[0])) {


                //case LOOK -> currentRoom.showInfo();
                case BAG -> player.lookIntoBag();
                case GO -> {
                    if (Direction.contains(command[1])) {
                        Direction direction = Direction.valueOf(command[1]);
                        Room targetRoom = currentRoom.getRoomIfPresent(direction);
                        if (targetRoom == null) {
                            System.out.println("There is no room at " + direction);

                        } else {
                            currentRoom = targetRoom;
                            currentRoom.showInfo();
                        }
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }
                case GET -> {
                    String itemName = InputController.joinCommand(command, 1);
                    Item itemToGet = currentRoom.getItemByName(itemName);
                    if (itemToGet == null) {
                        System.out.println("There is no " + itemName + " in the room");
                    }
                    else if (player.addItemToBag(itemToGet){
                            currentRoom.removeItem(itemToGet);
                            System.out.println("You got the " + itemName + "!");
                            System.out.println("You can't get the " + itemName);
                        }
                        else{
                            System.out.println("There is not enough space in the bag");
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
            }*/

        }
    }

    //TODO eliminare questo getter quando implementi MApController, ora serve solo per testare il programma
    public Room getEntry() {
        return entry;
    }
}
