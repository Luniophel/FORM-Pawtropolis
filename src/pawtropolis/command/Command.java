package pawtropolis.command;

import pawtropolis.game.GameController;

public abstract class Command {
    private GameController gc;

    public Command(GameController gc){
        this.gc = gc;
    }

    public abstract void execute();
}
