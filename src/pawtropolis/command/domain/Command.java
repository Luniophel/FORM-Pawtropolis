package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public abstract class Command {
    private GameController gc;

    public Command(GameController gc){
        this.gc = gc;
    }

    public abstract void execute(List<String> tokens);

    public static GameController getGc() {
        return this.gc;
    }
}
