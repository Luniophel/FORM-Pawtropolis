package pawtropolis.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.CommandGateway;
import pawtropolis.game.console.InputController;

@Component
public class GameController {

    private CommandGateway commandInvoker;
    private boolean isGameEnded = false;

    @Autowired
    private void setCommandInvoker (CommandGateway commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void endGame(){
        isGameEnded = true;
    }

    public void runGame() {

        while (!isGameEnded) {
            System.out.println("Where are you going to go?");
            System.out.print(">");

            commandInvoker.executeCommand( InputController.readString() );
        }
    }
}

