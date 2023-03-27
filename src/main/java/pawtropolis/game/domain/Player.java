package pawtropolis.game.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Component
@Entity
@Table(name = "Player")
public class Player {

    private static final int DEFAULT_BAG_SIZE = 10;
    private static final int DEFAULT_HEALTH_POINTS = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotNull
    private final String name;

    @NotNull
    private int healthPoints = DEFAULT_HEALTH_POINTS;

    @NotNull
    @OneToOne(optional = false)
    @JoinTable(
            name = "Bag",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
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