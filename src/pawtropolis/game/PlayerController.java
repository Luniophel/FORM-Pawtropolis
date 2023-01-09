package pawtropolis.game;

import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Room;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) { this.player = player; }

    public boolean isThereEnoughSlotsInBag(Item item){
        if (player.getPlayerBag().getAvailableSlots() >= item.getRequiredSlot())
            return true;
        else{
            return false;
        }
    }

    public Bag getBag() {
        return player.getPlayerBag();
    }

    public Item getItemFromBag(String itemName){
        for(Item item : player.getPlayerBag().getItems()){
            if (itemName.equalsIgnoreCase(item.getName())){
                return item;
            }
        }
        return null;
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
