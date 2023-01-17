package pawtropolis.game.console;

import pawtropolis.map.domain.Direction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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

    public static List<String> makeTokens(String input){
        if (!input.isEmpty()){
            List<String> tokens = new ArrayList<>();
            tokens = Arrays.stream(input.split(" ")).toList();
            return tokens;
        }
        return null;
    }
}

