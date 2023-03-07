package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;

@Component
public abstract class Command {

    protected GameController gameController;
    protected MapController mapController;
    protected Player player;

    @Autowired
    protected Command (GameController gameController, MapController mapController, Player player){
        this.gameController = gameController;
        this.mapController = mapController;
        this.player = player;
    }

    public abstract void execute(List<String> tokens);
}
