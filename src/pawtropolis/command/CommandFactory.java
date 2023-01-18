package pawtropolis.command;

import pawtropolis.command.domain.BagCommand;
import pawtropolis.command.domain.Command;
import pawtropolis.command.domain.GoCommand;
import pawtropolis.command.domain.LookCommand;
import pawtropolis.game.domain.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandFactory {
    private Map<Action, Command> commands;

    private static CommandFactory instance;

    private CommandFactory(){

        this.commands = new HashMap<>();

        commands.put(Action.LOOK, new LookCommand());
        commands.put(Action.BAG, new BagCommand());
        commands.put(Action.GO, new GoCommand());

    }

    public static CommandFactory getInstance() {
        if (instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(List<String> tokens){
       if (commands.containsKey(Action.act(tokens.get(0) ) ) ) {
           return commands.get(Action.act(tokens.get(0)));
       }
       return null;
    }
}
