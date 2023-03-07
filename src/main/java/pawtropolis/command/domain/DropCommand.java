package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class DropCommand extends Command{

    @Autowired
    protected DropCommand(GameController gameController, MapController mapController, Player player) {
        super(gameController, mapController, player);
    }

    @Override
    public void execute(List<String> tokens) {

        String itemName = InputController.getParameters(tokens);
        Item itemToDrop = player.getItemByName(itemName);
            if (itemToDrop == null) {
                System.out.println("You can't drop the " + itemName + ":\nThere is no such item in the bag");
            } else {
                player.removeItemFromBag(itemToDrop);
                mapController.addItemToCurrentRoom(itemToDrop);
                System.out.println("You dropped the " + itemName + "!");
            }


    }
}
