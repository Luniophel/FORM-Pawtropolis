package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public interface Command {
    void execute(List<String> tokens);
}
