package pawtropolis.game.console;

import pawtropolis.map.domain.Direction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {

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

    public static String joinCommand(String[] command, int position){
        String joinedString = null;
        for(int i=position; i<command.length; i++){
            joinedString = String.join(" ", command[i]);
        }
        return joinedString;
    }

}
