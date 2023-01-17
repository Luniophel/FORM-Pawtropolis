package pawtropolis.map.domain;

import java.util.Arrays;

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

    public static Direction dir(String s){
        return Arrays.stream(values())
                .filter(a -> s.equalsIgnoreCase(a.name))
                .findAny()
                .orElse(INVALID);
    }
}
