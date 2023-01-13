package pawtropolis.map.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west"),
    INVALID(null);

    private final String name;
    Direction(String name) {
        this.name=name;
    }

    public static boolean contains(String directionToCompare) {
        for (Direction d : Direction.values()) {
            if (d.name().equals(directionToCompare)) {
                return true;
            }
        }
        return false;
    }
}
