package pawtropolis.game;

import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Action;
import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
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

        String input;
        String[] command;

        while(!gameEnded) {

            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            command = input.split(" ", 2);

            switch (Action.valueOf(command[0])){
                case LOOK   -> PlayerAction.lookAround(currentRoom);
                case BAG    -> PlayerAction.lookIntoPlayerBag(player);
                case GO     ->
                case GET    -> System.out.println("'GET <ItemName>' : if it's present, pick that item from the room and put it in your bag.");
                case DROP   -> System.out.println("'DROP <ItemName>' : if it's present, pick that item from the bag and drop it in the current room.");
                case EXIT   -> System.out.println("Close the game.");
            }

            //GET COMMAND
            if ( (command.length>1) && (command[0].equalsIgnoreCase("GET")) ) {
                String itemName = InputController.joinCommand(command,1);
                Item itemToGet = roomController.getItemByNameFromRoom(currentRoom, itemName);
                if (itemToGet != null){
                    if (playerController.isThereEnoughSlotsInBag(itemToGet)){
                        playerController.addItemToBag(itemToGet);
                        roomController.removeItemFromRoom(currentRoom, itemToGet);
                        System.out.println("You got the " + itemName + "!");
                        continue;
                    }
                    else {
                        System.out.println("You can't get the " + itemName );
                        System.out.println("There is not enough space in the bag");
                        continue;
                    }
                }
                else {
                    System.out.println("There is no " + itemName + " in the room");
                }
            }

            //DROP COMMAND
            if ( (command.length>1) && (command[0].equalsIgnoreCase("DROP")) ) {
                String itemName = InputController.joinCommand(command, 1);
                Item itemToDrop = playerController.getItemFromBag(itemName);
                if (itemToDrop != null) {
                    playerController.removeItemFromBag(itemToDrop);
                    roomController.addItemToRoom(currentRoom, itemToDrop);
                    System.out.println("You dropped the " + itemName + "!");
                    continue;
                }
                else {
                    System.out.println("You can't drop the " + itemName);
                    System.out.println("There is no " + itemName + " in the bag");
                    continue;
                }
            }

            //EXIT COMMAND
            if (input.equalsIgnoreCase("EXIT")) {
                gameEnded = true;
            }
            else{
                System.out.println("Unknown command");
            }
        }
    }

    
    static class PlayerAction {

        static PlayerController playerController = new PlayerController();
        static RoomController roomController = new RoomController();

        static void lookAround(Room room){
            roomController.showRoomInfo(room);
        }
        static void lookIntoPlayerBag(Player player){
            playerController.showBagContent();
        }
        static void moveFromHereToDirection(Room currentRoom, Direction direction){
            if (Direction.contains(direction.toString())) {
                Room targetRoom = roomController.getRoomIfPresent(currentRoom, direction);
                if (targetRoom != null) {
                    currentRoom = targetRoom;
                    roomController.showRoomInfo(currentRoom);
                }
                else {
                    System.out.println("There is no room at " + direction);
                }
            }else {
                System.out.println("Invalid direction.");
            }
        }
    }
}
