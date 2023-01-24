package main.java.pawtropolis.game.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
  private String name;
  private String description;
  private int requiredSlot;

    public Item(String name, String description, int requiredSlot) {
        this.name = name;
        this.description = description;
        this.requiredSlot = requiredSlot;
    }
}