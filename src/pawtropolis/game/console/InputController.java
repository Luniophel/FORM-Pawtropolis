package pawtropolis.game.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static String getParameters(List<String> tokens, int position){
        String parameters = null;
        parameters =tokens.subList(1, (tokens.size())).stream()
                .collect(Collectors.joining(" "));
       /* for(int i=position; i< tokens.size(); i++){
            parameters = (tokens.subList(1, (tokens.size()-1))).toString();
        }*/
        return parameters;
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

