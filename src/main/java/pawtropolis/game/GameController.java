package pawtropolis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.CommandGateway;
import pawtropolis.game.console.InputController;

@Component
public class GameController {

    private final CommandGateway commandGateway;
    private boolean isGameEnded = false;

    @Autowired
    private GameController (CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    public void endGame(){
        isGameEnded = true;
    }

    public void runGame() {

        while (!isGameEnded) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            commandGateway.executeCommand( InputController.readString() );
        }
    }
}

