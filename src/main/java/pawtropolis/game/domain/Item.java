package pawtropolis.game.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private int requiredSlot;

    public Item(String name, String description, int requiredSlot) {
    this.name = name;
    this.description = description;
    this.requiredSlot = requiredSlot;
    }
}