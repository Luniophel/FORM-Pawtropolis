package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

import java.util.List;
@Component
public class ExitCommand implements Command{
    @Autowired
    GameController gameController;
    @Override
    public void execute(List<String> tokens) {
        System.out.println(" GAME OVER.");
        gameController.setGameEndedToTrue();
    }
}
