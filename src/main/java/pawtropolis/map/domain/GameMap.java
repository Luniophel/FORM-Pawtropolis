package pawtropolis.map.domain;

import javax.persistence.*;

@Entity
@Table(name = "map")
public class GameMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
