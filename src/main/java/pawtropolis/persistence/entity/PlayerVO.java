package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Getter
@Component
@Entity
@Table(name = "player")
public class PlayerVO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private int healthPoints;
    @OneToOne(optional = false)
    @JoinTable(
            name = "bag",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    @NonNull
    private BagVO bag;
}