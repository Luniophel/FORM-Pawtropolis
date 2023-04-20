package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import pawtropolis.persistence.JpaEntity;

import java.util.Objects;

@Entity
@Table(name = "item_in_bag")
@Getter
@Setter
@NoArgsConstructor
public class Item_Bag implements JpaEntity {

    @EmbeddedId
    private Item_BagKey id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @MapsId("itemId")
    private ItemVO item;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    @MapsId("bagId")
    private BagVO bag;

    @Column(name = "item_counter")
    private Integer itemCounter;

    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    static class Item_BagKey implements JpaEntity {

        @Column(name = "item_id")
        private Integer itemId;

        @Column(name = "bag_id")
        private Integer bagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item_Bag itemBag = (Item_Bag) o;
        return id != null && Objects.equals(id, itemBag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
