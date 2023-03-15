package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.command.domain.*;
import pawtropolis.game.domain.Action;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {
    private final Map<Action, Command> commands;

    @Autowired
    private CommandFactory(ApplicationContext ctx){

        this.commands = new EnumMap<>(Action.class);

        commands.put(Action.LOOK, ctx.getBean(LookCommand.class));
        commands.put(Action.BAG, ctx.getBean(BagCommand.class));
        commands.put(Action.GO, ctx.getBean(GoCommand.class));
        commands.put(Action.GET, ctx.getBean(GetCommand.class));
        commands.put(Action.DROP, ctx.getBean(DropCommand.class));
        commands.put(Action.EXIT,  ctx.getBean(ExitCommand.class));
        commands.put(Action.INVALID, ctx.getBean(UnknownCommand.class));
    }

    public Command getCommand(List<String> tokens){
        if (tokens.isEmpty()){
            return commands.get(Action.INVALID);
        }
        else {
            String userCommandInput = tokens.get(0);
            return commands.get(Action.act(userCommandInput));
        }
    }
}
