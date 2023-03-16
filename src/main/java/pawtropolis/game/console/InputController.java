package pawtropolis.game.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {

    private static final String INPUT_DELIMITER = " ";
    private static final String INPUT_REGEX = " ";

    private InputController() {}

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine().toUpperCase();
        } catch (IOException e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }

    public static String getParameters(List<String> tokens){
        return String.join(INPUT_DELIMITER, tokens.subList(1, (tokens.size())));
    }

    public static List<String> makeTokens(String input){
        List<String> tokens = new ArrayList<>();
        if (!input.isEmpty()){
            tokens = Arrays.stream(input.split(INPUT_REGEX)).toList();
        }
        return tokens;
    }

}

