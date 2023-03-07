package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Item;

import java.util.List;
@Component
public class DropCommand implements Command{
    @Autowired
    GameController gameController;
    @Override
    public void execute(List<String> tokens) {

        String itemName = InputController.getParameters(tokens);
        Item itemToDrop = gameController.getItemFromPlayerBag(itemName);
            if (itemToDrop == null) {
                System.out.println("You can't drop the " + itemName + ":\nThere is no such item in the bag");
            } else {
                gameController.removeItemFromPlayerBag(itemToDrop);
                gameController.addItemToRoom(itemToDrop);
                System.out.println("You dropped the " + itemName + "!");
            }


    }
}
