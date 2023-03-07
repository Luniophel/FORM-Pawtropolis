package pawtropolis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.CommandFactory;
import pawtropolis.command.domain.Command;
import pawtropolis.game.console.InputController;

import java.util.List;

@Component
public class GameController {

    private final CommandFactory commandFactory ;
    private boolean endGame = false;

    @Autowired
    private GameController(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void endGame(){
        endGame = true;
    }

    public void runGame() {
        String input;

        while (!endGame) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            input = InputController.readString().toUpperCase();
            List<String> tokens = InputController.makeTokens(input);
            Command command = commandFactory.getCommand(tokens);
            command.execute(tokens);
        }
    }
}

