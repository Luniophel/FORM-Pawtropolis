package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.Command;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class LookCommand extends Command {

    @Autowired
    protected LookCommand(GameController gameController, MapController mapController, Player player) {
        super(gameController, mapController, player);
    }

    @Override
    protected void execute(List<String> tokens){
        mapController.showCurrentRoomInfo();
    }
}

