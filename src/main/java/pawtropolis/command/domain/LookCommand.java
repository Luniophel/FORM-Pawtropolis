package pawtropolis.command.domain;

import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class LookCommand extends Command{

    protected LookCommand(GameController gameController, MapController mapController) {
        super(gameController, mapController);
    }

    @Override
    public void execute(List<String> tokens){
        gameController.showRoomInfo();
    }
}

