package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.game.console.InputController;

import java.util.List;

@Component
public class CommandGateway {

    private final ApplicationContext ctx;

    @Autowired
    private CommandGateway(ApplicationContext ctx){
        this.ctx = ctx;
    }

    public void executeCommand(String input){
        List<String> tokens = InputController.makeTokens(input);
        ctx.getBean(CommandProvider.class)
                .getCommand(tokens)
                .execute(tokens);
    }

}
