package pawtropolis.command.domain;

import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class ExitCommand extends Command{

    protected ExitCommand(GameController gameController, MapController mapController) {
        super(gameController, mapController);
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println(" GAME OVER.");
        gameController.setGameEndedToTrue();
    }
}
