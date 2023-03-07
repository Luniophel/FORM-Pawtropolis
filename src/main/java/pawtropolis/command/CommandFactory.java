package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pawtropolis.command.domain.*;
import pawtropolis.game.domain.Action;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {
    private Map<Action, Command> commands;

    private Command unknownCommand = new UnknownCommand();
    @Autowired
    @Lazy
    private CommandFactory( LookCommand lookCommand,
                            BagCommand bagCommand,
                            GoCommand goCommand,
                            GetCommand getCommand,
                            DropCommand dropCommand,
                            ExitCommand exitCommand){

        this.commands = new EnumMap<>(Action.class);

        commands.put(Action.LOOK, lookCommand);
        commands.put(Action.BAG, bagCommand);
        commands.put(Action.GO, goCommand);
        commands.put(Action.GET, getCommand);
        commands.put(Action.DROP,dropCommand);
        commands.put(Action.EXIT,  exitCommand);
    }

    public Command getCommand(List<String> tokens){
       if (commands.containsKey(Action.act(tokens.get(0) ) ) ) {
           return commands.get(Action.act(tokens.get(0)));
       }
       return unknownCommand;
    }
}
