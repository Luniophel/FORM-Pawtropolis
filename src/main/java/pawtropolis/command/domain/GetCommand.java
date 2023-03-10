package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;
import main.java.pawtropolis.game.console.InputController;
import main.java.pawtropolis.game.domain.Item;

import java.util.List;

public class GetCommand implements Command{

    public void execute(List<String> tokens){
        GameController gc = GameController.getIstance();

        String itemName = InputController.getParameters(tokens);
        Item itemToGet = gc.getItemFromCurrentRoom(itemName);
        if (itemToGet == null) {
            System.out.println("There is no " + itemName + " in the room");
        }
        else{
            if (gc.addItemToPlayerBag(itemToGet)){
                gc.removeItemFromCurrentRoom(itemToGet);
                System.out.println("You got the " + itemName + "!");

            }
            else{
                System.out.println("There is not enough space in the bag");
            }
        }

    }
}
