package pawtropolis.game.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pawtropolis.marshaller.IMarshallized;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Bag implements IMarshallized {

    private Integer id;

    private int maxSlots;
    private int availableSlots;
    private final Collection<Item> items = new ArrayList<>();

    public Bag(int maxSlots) {
        this.maxSlots = maxSlots;
        this.availableSlots = maxSlots;
    }

    public boolean areThereEnoughSlots(Item item){
        return (availableSlots >= item.getRequiredSlot());
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
        if (areThereEnoughSlots(item)){
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

    public String showInfo(){
        String bagInfo =
                "You look in your bag:\n\n"     +
                listAllItemsInBag() + "\n"      +
                "There are " + availableSlots   + " slots left."    ;
        //TODO Togliere il print una volta aggiunta un'interfaccia grafica
        System.out.println(bagInfo);
        return bagInfo;
    }

    private String listAllItemsInBag (){
        return items.isEmpty()
                ? "In this bag there are no items.\n"
                : "In this bag there are the following items:\n" +
                items.stream()
                        .map(item -> " #" + item.getName())
                        .collect(Collectors.joining(";\n"));
    }
}