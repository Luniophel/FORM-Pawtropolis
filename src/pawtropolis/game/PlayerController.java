package pawtropolis.game;

import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public boolean isThereEnoughSlotsInBag(Item item){
        if (player.getPlayerBag().getAvailableSlots() >= item.getRequiredSlot())
            return true;
        return false;
    }

    public boolean addItemtoBag(Item item) {
        if (isThereEnoughSlots(item)) {
            player.getPlayerBag().getItems().add(item);
            return true;
        }
        return false;
    }

    public void showBagContent(){
        if (player.getPlayerBag().getItems().isEmpty()){
            System.out.println("Your bag is empty");
        }
        else{
            System.out.println("You bag contains: ");
            for (Item item : player.getPlayerBag().getItems()) {
                System.out.println(item.getName() + " ");
            }
        }
    }
}
