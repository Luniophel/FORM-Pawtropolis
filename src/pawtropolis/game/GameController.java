package pawtropolis.game;

import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;

public class GameController {

    private MapController mapController;
    private Player player;
    private static GameController instance;

    private GameController() {
        this.mapController = new MapController();
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

    public Item getItemFromCurrentRoom(String itemName) {
        return mapController.getItemByItemName(itemName);
    }

    public boolean removeItemFromCurrentRoom(Item item) {
        return mapController.removeItem(item);
    }

    public boolean addItemToPlayerBag(Item item) {
        return player.addItemToBag(item);
    }

    public Player getPlayer(){return player;}

    public void runGame() {
        boolean gameEnded = false;
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

