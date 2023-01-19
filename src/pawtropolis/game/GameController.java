package pawtropolis.game;

import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Room;

import java.util.List;

public class GameController {

    private MapController mapController;
    private Player player;
    boolean gameEnded = false;
    private static GameController instance;

    private GameController() {
        this.mapController = new MapController();
    }
    public void setGameEndedToTrue(){
        gameEnded = true;
    }
    public MapController getMapController() {
        return mapController;
    }

    public static GameController getIstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public Room getCurrentRoom() {
        return mapController.getCurrentRoom();
    }

    public void showRoomInfo(){
        mapController.showCurrentRoomInfo();
    }

    public Item getItemFromCurrentRoom(String itemName) {
        return mapController.getItemByItemName(itemName);
    }

    public boolean removeItemFromCurrentRoom(Item item) {
        return mapController.removeItem(item);
    }

    public boolean addItemToPlayerBag(Item item) {
        return player.addItemToBag(item);
    }

    public void showPlayerBagContent(){
        player.lookIntoBag();
    }

    public void runGame() {
        String input;
        player = new Player("player01");
        while (!gameEnded) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            List<String> tokens = InputController.makeTokens(input);
            Command command = CommandFactory.getInstance().getCommand(tokens);
            command.execute(tokens);
        }
    }
}

