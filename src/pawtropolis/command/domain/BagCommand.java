package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class BagCommand extends Command{
    @Override
    public void execute(List<String> tokens){
        GameController.getIstance().getPlayer().lookIntoBag();
    }
}