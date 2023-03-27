package pawtropolis.game.console;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputController {

    private static final String INPUT_TOKENS_SEPARATOR = " ";

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

    public static List<String> makeTokens(String input){
        List<String> tokens = new ArrayList<>();
        if (!input.isEmpty()){
            tokens = Arrays.stream(input.split(INPUT_TOKENS_SEPARATOR)).toList();
        }
        return tokens;
    }

    public static String getParameters(List<String> tokens){
        return String.join(INPUT_TOKENS_SEPARATOR, tokens.subList(1, (tokens.size())));
    }

}