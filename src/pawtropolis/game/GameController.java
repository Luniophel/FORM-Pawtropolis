package pawtropolis.game;

import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Action;
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
            switch (Action.valueOf(command[0])) {
                case LOOK -> roomController.showRoomInfo(currentRoom);
                case BAG -> playerController.showBagContent();
                case GO -> {
                    if (Direction.contains(command[1])) {
                        Direction direction = Direction.valueOf(command[1]);
                        Room targetRoom = roomController.getRoomIfPresent(currentRoom, direction);
                        if (targetRoom != null) {
                            currentRoom = targetRoom;
                            roomController.showRoomInfo(currentRoom);
                        } else {
                            System.out.println("There is no room at " + direction);
                        }
                    } else {
                        System.out.println("Invalid direction.");
                    }
                }
                case GET -> {
                    String itemNameToGet = InputController.joinCommand(command, 1);
                    Item itemToGet = roomController.getItemByNameFromRoom(currentRoom, itemNameToGet);
                    if (itemToGet != null) {
                        if (playerController.isThereEnoughSlotsInBag(itemToGet)) {
                            playerController.addItemToBag(itemToGet);
                            roomController.removeItemFromRoom(currentRoom, itemToGet);
                            System.out.println("You got the " + itemNameToGet + "!");
                        } else {
                            System.out.println("You can't get the " + itemNameToGet);
                            System.out.println("There is not enough space in the bag");
                        }
                    } else {
                        System.out.println("There is no " + itemNameToGet + " in the room");
                    }
                }
                case DROP -> {
                    String itemNameToDrop = InputController.joinCommand(command, 1);
                    Item itemToDrop = playerController.getItemFromBag(itemNameToDrop);
                    if (itemToDrop != null) {
                        playerController.removeItemFromBag(itemToDrop);
                        roomController.addItemToRoom(currentRoom, itemToDrop);
                        System.out.println("You dropped the " + itemNameToDrop + "!");
                    } else {
                        System.out.println("You can't drop the " + itemNameToDrop);
                        System.out.println("There is no " + itemNameToDrop + " in the bag");
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
