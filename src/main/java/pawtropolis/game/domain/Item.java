package main.java.pawtropolis.game.domain;

public class Item {
  private String name;
  private String description;
  private int requiredSlot;

    public Item(String name, String description, int requiredSlot) {
        this.name = name;
        this.description = description;
        this.requiredSlot = requiredSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredSlot() {
        return requiredSlot;
    }

    public void setRequiredSlot(int requiredSlot) {
        this.requiredSlot = requiredSlot;
    }
}