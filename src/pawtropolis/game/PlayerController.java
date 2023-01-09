package pawtropolis.game;

import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Room;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) { this.player = player; }

    public void  lookAround(Room room){
        System.out.println("You're in " + room.getName());
        room.getAdiacentRooms().forEach((k, v) -> System.out.println((k + ":" + v.getName())));
    }

    public boolean isThereEnoughSlotsInBag(Item item){
        if (player.getPlayerBag().getAvailableSlots() >= item.getRequiredSlot())
            return true;
        else{
            return false;
        }
    }

    public boolean addItemtoBag(Item item) {
        if (isThereEnoughSlotsInBag(item)) {
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
