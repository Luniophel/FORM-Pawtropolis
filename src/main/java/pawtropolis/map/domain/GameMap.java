package pawtropolis.map.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "map")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//TODO Inserire un field che tenga nota delle EntryRoom della GameMap, attuare adeguate modifiche a Database
public class GameMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "map")
    private List<Room> rooms = new ArrayList<>();

    protected GameMap (@NonNull String name, List<Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }
}
