package main.java.pawtropolis.game.domain;

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

    public boolean isPresent(Item item){
        return items.stream().anyMatch(i -> i.equals(item));
    }

    public Item getItemIfPresent(String itemName){
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny()
                .orElse(null);
    }

    public boolean addItem(Item item){
        if (isThereEnoughSlots(item)){
            items.add(item);
            availableSlots -= item.getRequiredSlot();
            return true;
        }
        return false;
    }

    public Item removeItem(Item item){
        if (items.remove(item)) {
            availableSlots += item.getRequiredSlot();
            return item;
        }
        return null;
    }

    public void showInfo() {
        if (items.isEmpty()) {
            System.out.println("The bag is empty");
        } else {
            System.out.println("The bag contains the following items:");
            for (Item item : items) {
                System.out.println(" # " + item.getName());
            }
        }
    }

    //GETTER & SETTER

    public int getAvailableSlots() {
        return availableSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

}