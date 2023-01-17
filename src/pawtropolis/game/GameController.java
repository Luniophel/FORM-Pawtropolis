package pawtropolis.game;

import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Action;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.util.List;

public class GameController {

    //TODO Inserisci singleton appena MapController è implementato
    private MapController mapController;
    private Player player;
    private static GameController instance;

    public static  GameController getIstance(){
        if (instance == null){
             instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        this.mapController = new MapController();
    }

    public Room getCurrentRoom(){
       return  mapController.getCurrentRoom();
    }

    public void runGame() {

        boolean gameEnded = false;

        String input;

        new Player("player01");

        while(!gameEnded) {

            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();

            List<String> tokens = InputController.makeTokens(input);
            Command command = CommandFactory.getInstance().getCommand(tokens);
            command.execute(tokens);

            //TODO il commento seguente è stato inserito solo per testare la classe Look (sottoclasse di Command)
            /*command = input.split(" ", 2);
             switch (Action.valueOf(command[0])) {


                //case LOOK -> currentRoom.showInfo();
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
            }*/

        }
    }
}
