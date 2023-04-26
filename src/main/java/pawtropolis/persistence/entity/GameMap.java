package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "game_map")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//TODO Inserire un field che tenga nota delle EntryRoom della GameMap, attuare adeguate modifiche a Database
public class GameMap implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "gameMap")
    private Set<RoomVO> rooms;

}
