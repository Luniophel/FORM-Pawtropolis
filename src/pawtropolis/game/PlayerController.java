package pawtropolis.game;

import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;

import java.util.Collection;
import java.util.Optional;

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
        Collection<Item> items = getBag().getItems();
        Item item = items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny()
                .orElse(null);
        return item;
    }

    public void removeItemFromBag(Item itemToRemove){
        getBag().removeItem(itemToRemove);
    }

    public void addItemToBag(Item itemToAdd){
        getBag().addItem(itemToAdd);
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
