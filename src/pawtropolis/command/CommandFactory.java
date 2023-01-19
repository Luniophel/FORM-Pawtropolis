package pawtropolis.command;

import pawtropolis.command.domain.*;
import pawtropolis.game.domain.Action;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CommandFactory {
    private Map<Action, Command> commands;

    private static CommandFactory instance;
    private Command unknownCommand = new UnknownCommand();

    private CommandFactory(){

        this.commands = new EnumMap<>(Action.class);

        commands.put(Action.LOOK, new LookCommand());
        commands.put(Action.BAG, new BagCommand());
        commands.put(Action.GO, new GoCommand());
        commands.put(Action.GET, new GetCommand());
        commands.put(Action.DROP, new DropCommand());
        commands.put(Action.EXIT, new ExitCommand());
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
       return unknownCommand;
    }
}
