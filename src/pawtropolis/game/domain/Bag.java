package pawtropolis.game.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Bag {
   private Collection<Item> items = new ArrayList<Item>();
   private int maxSlots;
   private int availableSlots;

    public Bag(int maxSlots) {
        this.maxSlots = maxSlots;
        this.availableSlots = maxSlots;
    }

    public void addItemToBag(Item item){
        items.add(item);
        availableSlots -= item.getRequiredSlot();
    }

    public void removeItemFromBag(Item item){
        items.remove(item);
        availableSlots += item.getRequiredSlot();
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}