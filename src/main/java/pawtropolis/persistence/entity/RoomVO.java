package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import pawtropolis.map.domain.Direction;
import pawtropolis.marshaller.IMarshallizable;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Room")
//TODO Necessario refactor con adeguata referenza a GameMap nella creazione di una Room
public class RoomVO implements Serializable, IMarshallizable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @NonNull
    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "rooms")
    @Getter
    private Set<ItemVO> items;

    @Getter
    @ManyToMany
    @JoinTable(name = "room_adjacency",
            joinColumns = {
                    @JoinColumn(name = "room_a_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "room_b_id", referencedColumnName = "id")
            })
            @MapKeyEnumerated(EnumType.STRING)
            @MapKeyColumn(name = "from_a_to_b_direction", table = "room_adjacency")
            private Map<Direction, RoomVO> adjacentRooms;

            @ManyToOne
            @JoinColumn(name = "map_id")
            private GameMap gameMap;
}
