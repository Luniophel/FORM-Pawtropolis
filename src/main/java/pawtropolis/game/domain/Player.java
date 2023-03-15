package pawtropolis.game.domain;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Player {

    private static final int DEFAULT_BAG_SIZE = 10;
    private static final int DEFAULT_HEALTH_POINTS = 100;

    @NonNull
    private final String name;
    private int healthPoints = DEFAULT_HEALTH_POINTS;
    private Bag bag = new Bag(DEFAULT_BAG_SIZE);

    @Autowired
    public Player() {
        this.name = "Player01";
    }

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