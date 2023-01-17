package pawtropolis.command;

import pawtropolis.command.domain.Command;
import pawtropolis.command.domain.Look;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Action;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Class;

public class CommandFactory {
    private Map<String, Command> commands;

    private static CommandFactory instance;

    private CommandFactory(){

        this.commands = new HashMap<>();

        commands.put("LOOK", new Look());
    }

    public static CommandFactory getInstance() {
        if (instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(List<String> tokens){
       if (commands.containsKey(tokens.get(0))) {
           return commands.get(tokens.get(0));
       }
       return null;
    }
}
