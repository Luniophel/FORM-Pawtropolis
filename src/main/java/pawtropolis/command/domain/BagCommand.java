package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;

import java.util.List;

public class BagCommand implements Command{
    @Override
    public void execute(List<String> tokens){
        GameController.getIstance().showPlayerBagContent();
    }
}
