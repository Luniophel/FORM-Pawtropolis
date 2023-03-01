package pawtropolis.game.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
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