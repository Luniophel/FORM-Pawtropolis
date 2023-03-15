package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandInvoker {

    private final ApplicationContext ctx;

    @Autowired
    private CommandInvoker(ApplicationContext ctx){
        this.ctx = ctx;
    }

    public void executeCommand(List<String> tokens){
        ctx.getBean(CommandFactory.class)
                .getCommand(tokens)
                .execute(tokens);
    }

}
