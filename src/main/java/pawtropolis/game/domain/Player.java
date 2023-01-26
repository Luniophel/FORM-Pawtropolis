package pawtropolis.game.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

    static final int DEFAULT_BAG_SIZE = 10;
    static final int DEFAULT_HEALTH_POINTS = 100;

    @NonNull
    private final String name;
    private int healthPoints = DEFAULT_HEALTH_POINTS;
    private Bag bag = new Bag(DEFAULT_BAG_SIZE);


    public Item getItemByName(String itemName) {
        return bag.getItemIfPresent(itemName);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public boolean addItemToBag(Item item) {
        return bag.addItem(item);
    }

    public void lookIntoBag() {
        bag.showInfo();
    }
}