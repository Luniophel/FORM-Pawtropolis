package pawtropolis.command.domain;

import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class BagCommand extends Command{

    protected BagCommand(GameController gameController, MapController mapController) {
        super(gameController, mapController);
    }

    @Override
    public void execute(List<String> tokens){
        gameController.showPlayerBagContent();
    }
}
