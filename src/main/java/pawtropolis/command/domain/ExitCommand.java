package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;

import java.util.List;

public class ExitCommand implements Command{
    @Override
    public void execute(List<String> tokens) {
        System.out.println(" GAME OVER.");
        GameController.getIstance().setGameEndedToTrue();
    }
}
