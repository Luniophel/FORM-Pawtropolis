package pawtropolis.map.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "map")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//TODO Inserire un field che tenga nota delle EntryRoom della GameMap, attuare adeguate modifiche a Database
public class GameMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    protected GameMap (String name){
        this.name = name;
    }
}
