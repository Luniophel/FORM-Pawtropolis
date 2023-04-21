package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Item")
public class ItemVO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String description;

    private int requiredSlots;

    @ManyToMany
    @JoinTable(name = "item_in_bag",
            joinColumns = {@JoinColumn(name = "item_id")}, inverseJoinColumns = @JoinColumn(name = "bag_id"))
    private Set<BagVO> bags;

    @ManyToMany
    @JoinTable(name = "item_in_room",
            joinColumns = {@JoinColumn(name = "item_id")}, inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<RoomVO> rooms;

}