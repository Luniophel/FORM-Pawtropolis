package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class LookCommand extends Command{
    public void execute(List<String> tokens){
        GameController.getIstance().showRoomInfo();
    }
}

