package main.java.pawtropolis.game.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static String getParameters(List<String> tokens){
        return String.join(" ", tokens.subList(1, (tokens.size())));
    }

    public static List<String> makeTokens(String input){
        List<String> tokens = new ArrayList<>();
        if (!input.isEmpty()){
            tokens = Arrays.stream(input.split(" ")).toList();

        }
        return tokens;
    }
}

