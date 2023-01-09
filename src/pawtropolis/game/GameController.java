package pawtropolis.game;

import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Room;

import pawtropolis.map.domain.Direction;

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
        RoomController roomController = new RoomController();

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
                roomController.showRoomInfo(currentRoom);
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
                        roomController.showRoomInfo(currentRoom);
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
            if ( (command.length>1) && (command[0].equalsIgnoreCase("GET")) ) {
                String itemName = InputController.joinCommand(command,1);
                Item itemToGet = roomController.getItemFromRoom(currentRoom, itemName);
                if (itemToGet != null){
                    if (playerController.isThereEnoughSlotsInBag(itemToGet)){
                        playerController.getBag().addItemToBag(itemToGet);
                        roomController.removeItemfromRoom(currentRoom, itemToGet);
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

            //EXIT COMMAND
            if (input.equalsIgnoreCase("EXIT")) {
                gameEnded = true;
            }
        }
    }
}
