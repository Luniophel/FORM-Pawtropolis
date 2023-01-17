package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class Look {

    public Look(GameController gc){
        super(gc);
    }
    public void execute(List<String> tokens){
        Command.getGc().getEntry().showInfo();
    }
}

