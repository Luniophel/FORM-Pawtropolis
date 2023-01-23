package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;
import main.java.pawtropolis.game.console.InputController;
import main.java.pawtropolis.game.domain.Item;

import java.util.List;

public class DropCommand implements Command{
    @Override
    public void execute(List<String> tokens) {

        GameController gc = GameController.getIstance();
        String itemName = InputController.getParameters(tokens);
        Item itemToDrop = gc.getItemFromPlayerBag(itemName);
            if (itemToDrop == null) {
                System.out.println("You can't drop the " + itemName + ":\nThere is no such item in the bag");
            } else {
                gc.removeItemFromPlayerBag(itemToDrop);
                gc.addItemToRoom(itemToDrop);
                System.out.println("You dropped the " + itemName + "!");
            }


    }
}
