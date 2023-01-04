package pawtropolis.game.console;

import pawtropolis.map.domain.Direction;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputController {

    // non ci interessa istanziare questa classe, ne usiamo solo i metodi static stateless
    private InputController() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }
    public static boolean isValidDirection(final String direction) {
        Direction[] directions= Direction.values();
        for (Direction d: directions){
            if (d.toString().equals(direction))
                return true;
        }
        return false;
    }
}
