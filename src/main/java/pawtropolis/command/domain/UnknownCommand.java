package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;

import java.util.List;
@Component
public class UnknownCommand extends Command{

    @Autowired
    protected UnknownCommand(GameController gameController, MapController mapController, Player player) {
        super(gameController, mapController, player);
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println("Unknown command !");
    }
}
