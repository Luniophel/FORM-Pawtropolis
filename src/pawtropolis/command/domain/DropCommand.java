package pawtropolis.command.domain;

import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Item;

import java.util.List;

public class DropCommand implements Command{
    @Override
    public void execute(List<String> tokens) {

        GameController gc = GameController.getIstance();
        String itemName = InputController.getParameters(tokens, 1);
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
