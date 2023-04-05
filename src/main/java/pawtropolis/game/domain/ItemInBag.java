package pawtropolis.game.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_in_bag")
public class ItemInBag {

    @EmbeddedId
    private ItemInBagKey id;

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
@EqualsAndHashCode
class ItemInBagKey implements Serializable {

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "bag_id")
    private Integer bagId;
}
