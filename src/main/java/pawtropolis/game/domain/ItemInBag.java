package pawtropolis.game.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_in_bag")
public class ItemInBag {

    @EmbeddedId
    private ItemBagId id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @MapsId("itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    @MapsId("bagId")
    private Bag bag;

    @Column(name = "item_counter")
    private Integer itemCounter;

}

@Embeddable
class ItemBagId implements Serializable {
    private Integer itemId;
    private Integer bagId;
}
