package pawtropolis.map.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public static boolean contains(String directionToCompare) {
        for (Direction d : Direction.values()) {
            if (d.name().equals(directionToCompare)) {
                return true;
            }
        }
        return false;
    }
}
