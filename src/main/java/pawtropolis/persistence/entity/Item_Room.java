package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pawtropolis.persistence.JpaEntity;

@Entity
@Table(name = "item_in_room")
@Getter
@Setter
@NoArgsConstructor
public class Item_Room{

    @EmbeddedId
    private Item_RoomKey id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @MapsId("itemId")
    private ItemVO item;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @MapsId("roomId")
    private RoomVO room;

    @Column(name = "item_counter")
    private Integer itemCounter;

    @Embeddable
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    static class Item_RoomKey implements JpaEntity {

        @Column(name = "item_id")
        private Integer itemId;

        @Column(name = "room_id")
        private Integer roomId;
    }
}

