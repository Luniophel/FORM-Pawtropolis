package pawtropolis.game.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pawtropolis.marshaller.IMarshallized;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements IMarshallized {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String description;

    private int requiredSlot;

    public Item(String name, String description, int requiredSlot) {
    this.name = name;
    this.description = description;
    this.requiredSlot = requiredSlot;
    }
}