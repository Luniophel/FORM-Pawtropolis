package pawtropolis.game.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Bag {
   private Collection<Item> items = new ArrayList<>();
   private int maxSlots;
   private int availableSlots;

    public boolean isThereEnoughSlots(Item item){
        return (availableSlots >= item.getRequiredSlot());
    }

    public Bag(int maxSlots) {
        this.maxSlots = maxSlots;
        this.availableSlots = maxSlots;
    }

    public Item getItemIfPresent(String itemName){
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny()
                .orElse(null);
    }

    public void addItem(Item item){
        items.add(item);
        availableSlots -= item.getRequiredSlot();
    }

    public void removeItem(Item item){
        items.remove(item);
        availableSlots += item.getRequiredSlot();
    }

    //GETTER & SETTER

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }
}