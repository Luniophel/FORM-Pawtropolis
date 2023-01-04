package pawtropolis.game;

import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.net.StandardSocketOptions;
import java.util.function.Consumer;
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

    public void lookInsideBag(Bag bag){
        for (Item i : bag.getItems()) {
            System.out.println(i.getName());
        }
    }

    public Item getItemFromRoom(Room room, String itemName){
        for (Item i : room.getItems()) {
            if (itemName.equalsIgnoreCase(i.getName())){
                return i;
            }
        }
        return null;
    }

    public void runGame() {
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString().toUpperCase();


            if (input.equalsIgnoreCase("LOOK")){
                lookAround(currentRoom);
                continue;
            }

            if (Pattern.matches("GO [a-zA-Z]{3,5}?",input)) {
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
                else{
                    System.out.println("Comando errato");
                }
                continue;
            }

            if (Pattern.matches("GET [a-zA-Z]{1,5}?",input)) {

                String itemName = input.substring(4);
                Item item = getItemFromRoom(currentRoom,itemName);

                if (item == null) {
                    System.out.println("Non trovo: " + itemName);
                }
                else {
                    if (item.getRequiredSlot() > player.getPlayerBag().getAvailableSlots()){
                        System.out.println("Not enough free slots for item: " + item.getName());
                    }
                    else {
                        System.out.println("Hai preso l'item: " + item.getName());
                        currentRoom.getItems().remove(item);
                        player.getPlayerBag().getItems().add(item);
                        player.getPlayerBag().setAvailableSlots(player.getPlayerBag().getAvailableSlots() - 1);
                        lookInsideBag(player.getPlayerBag());
                    }
                }
                continue;
            }

            if (input.equalsIgnoreCase("EXIT")) {
                gameEnded = true;
            }
        }
    }
}
