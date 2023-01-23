package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;

import java.util.List;

public class LookCommand implements Command{
    public void execute(List<String> tokens){

        GameController.getIstance().showRoomInfo();
    }
}

