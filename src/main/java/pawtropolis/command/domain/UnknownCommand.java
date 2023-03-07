package pawtropolis.command.domain;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UnknownCommand implements Command{
    @Override
    public void execute(List<String> tokens) {
        System.out.println("Unknown command !");
    }
}
