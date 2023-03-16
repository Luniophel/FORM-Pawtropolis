package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.Command;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class GetCommand extends Command {

    @Autowired
    protected GetCommand(GameController gameController, MapController mapController, Player player) {
        super(gameController, mapController, player);
    }

    @Override
    protected void execute(List<String> tokens){

        String itemName = InputController.getParameters(tokens);
        Item itemToGet = mapController.getItemByItemName(itemName);
        if (itemToGet == null) {
            System.out.println("There is no " + itemName + " in the room");
        }
        else{
            if (player.addItemToBag(itemToGet)){
                mapController.removeItemFromCurrentRoom(itemToGet);
                System.out.println("You got the " + itemName + "!");
            }
            else {
                System.out.println("There is not enough space in the bag");
            }
        }

    }
}
