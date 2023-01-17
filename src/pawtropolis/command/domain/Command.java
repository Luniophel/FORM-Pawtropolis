package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public abstract class Command {
    public abstract void execute(List<String> tokens);
}
