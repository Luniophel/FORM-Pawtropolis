package pawtropolis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.CommandInvoker;
import pawtropolis.game.console.InputController;

import java.util.List;

@Component
public class GameController {

    private CommandInvoker commandInvoker;
    private boolean isGameEnded = false;

    @Autowired
    private void setCommandInvoker (CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void endGame(){
        isGameEnded = true;
    }

    public void runGame() {
        String input;

        while (!isGameEnded) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            List<String> tokens = InputController.makeTokens(input);
            commandInvoker.executeCommand(tokens);
        }
    }
}

