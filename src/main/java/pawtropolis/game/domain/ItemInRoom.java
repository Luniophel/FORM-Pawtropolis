package pawtropolis.game.domain;

import lombok.EqualsAndHashCode;
import pawtropolis.map.domain.Room;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_in_room")
public class ItemInRoom {

    @EmbeddedId
    private ItemRoomId id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @MapsId("itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @MapsId("roomId")
    private Room room;

    @Column(name = "item_counter")
    private Integer itemCounter;

}

@Embeddable
@EqualsAndHashCode
class ItemRoomId implements Serializable {

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "room_id")
    private Integer roomId;
}
