package pawtropolis.command.domain;

import java.util.List;

public class InvalidCommand extends Command{
    @Override
    public void execute(List<String> tokens) {
        System.out.println("Unknown command !");
    }
}
