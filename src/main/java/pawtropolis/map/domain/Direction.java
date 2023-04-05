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

    public static Direction of(String s){
        return Arrays.stream(values())
                .filter(a -> s.equalsIgnoreCase(a.name))
                .findAny()
                .orElse(INVALID);
    }

    public static Direction oppositeOf(Direction dir){
        return switch (dir) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case INVALID -> INVALID;
        };
    }
}
