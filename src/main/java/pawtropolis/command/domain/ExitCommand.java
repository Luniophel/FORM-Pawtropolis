package pawtropolis.command.domain;

import pawtropolis.game.GameController;

import java.util.List;

public class ExitCommand implements Command{
    @Override
    public void execute(List<String> tokens) {
        System.out.println(" GAME OVER.");
        GameController.getIstance().setGameEndedToTrue();
    }
}
