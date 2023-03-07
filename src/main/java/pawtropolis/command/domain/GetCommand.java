package pawtropolis.command.domain;

import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Item;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class GetCommand extends Command{

    protected GetCommand(GameController gameController, MapController mapController) {
        super(gameController, mapController);
    }

    @Override
    public void execute(List<String> tokens){

        String itemName = InputController.getParameters(tokens);
        Item itemToGet = gameController.getItemFromCurrentRoom(itemName);
        if (itemToGet == null) {
            System.out.println("There is no " + itemName + " in the room");
        }
        else{
            if (gameController.addItemToPlayerBag(itemToGet)){
                gameController.removeItemFromCurrentRoom(itemToGet);
                System.out.println("You got the " + itemName + "!");

            }
            else{
                System.out.println("There is not enough space in the bag");
            }
        }

    }
}
