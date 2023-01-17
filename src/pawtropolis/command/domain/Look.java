package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class Look extends Command{
    public void execute(List<String> tokens){
        GameController.getIstance().getCurrentRoom().showInfo();
    }
}

