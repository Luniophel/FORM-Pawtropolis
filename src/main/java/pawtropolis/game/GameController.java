package pawtropolis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;

@Component
public class GameController {

    private CommandFactory commandFactory ;
    private MapController mapController;
    private Player player;
    boolean gameEnded = false;

    @Autowired
    private GameController(MapController mapController, CommandFactory commandFactory) {
        this.mapController = mapController;
        this.commandFactory = commandFactory;
        this.player = new Player("player01");
    }
    public void setGameEndedToTrue(){
        gameEnded = true;
    }
    public MapController getMapController() {
        return mapController;
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
    public Item getItemFromPlayerBag(String itemName){
        return player.getItemByName(itemName);
    }
    public void removeItemFromPlayerBag(Item itemToRemove){
        player.removeItemFromBag(itemToRemove);
    }
    public void addItemToRoom(Item itemToAdd){
        mapController.addItemToCurrentRoom(itemToAdd);
    }
    public void showPlayerBagContent(){
        player.lookIntoBag();
    }

    public void runGame() {
        String input;

        while (!gameEnded) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            List<String> tokens = InputController.makeTokens(input);
            Command command = commandFactory.getCommand(tokens);
            command.execute(tokens);
        }
    }
}

