package pawtropolis.game.domain;

import java.util.Arrays;

public enum Action {
    LOOK("look"),
    BAG("bag"),
    GO("go"),
    GET("get"),
    DROP("drop"),
    EXIT("exit"),
    HELP("help"),
    INVALID(null);

    private final String name;

    Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Action act(String s){
        return Arrays.stream(values())
                        .filter(a -> s.equalsIgnoreCase(a.name))
                        .findAny()
                        .orElse(INVALID);
    }
}

