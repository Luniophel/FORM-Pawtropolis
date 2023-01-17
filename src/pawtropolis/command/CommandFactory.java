package pawtropolis.command;

import pawtropolis.command.domain.Command;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Action;

import java.util.HashMap;
import java.util.Map;
import java.lang.Class;

public class CommandFactory {
    private Map<String, Command> commands;
    private GameController gameController;

    public CommandFactory(){
        this.commands = new HashMap<>();
        this.inputFormatter = new InputFormatter();

        for (Action action : Action.values()){
            String actionToString = action.toString();
            Class clazz = Class.forName(actionToString);
            this.commands.put(
                    actionToString,
                    clazz.getConstructor(GameController.class).newInstance() );
        }
    }

    public Command getCommandFromString(String input){


        return commands.get(comando) ? commands.containsKey(comando) : null;
        /*if (commands.containsKey(comando)) {
            return commands.get(comando);
        }
        return null;*/
    }

}
