package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class Look {

    private GameController gc;
    public Look(GameController gc){
        super();
        this.gc = gc;
    }

    public void execute(List<String> tokens){
        gc.getEntry().showInfo();
    }
}

