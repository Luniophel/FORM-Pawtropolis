package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;

import java.util.List;

@Component
public abstract class Command {

    protected GameController gameController;
    protected MapController mapController;

    @Autowired
    protected Command (GameController gameController, MapController mapController){
        this.gameController = gameController;
        this.mapController = mapController;
    }

    public abstract void execute(List<String> tokens);
}
