package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Direction;

import java.util.List;
@Component
public class GoCommand extends Command{

    @Autowired
    protected GoCommand(GameController gameController, MapController mapController, Player player) {
        super(gameController, mapController, player);
    }

    @Override
    public void execute(List<String> tokens) {
        Direction direction = Direction.of(InputController.getParameters(tokens));
        if(direction == Direction.INVALID) {
            System.out.println("Invalid direction");
        }
        if (mapController.isRoomAtDirection(direction)) {
            mapController.changeRoom(direction);
            mapController.getCurrentRoom().showInfo();
        } else {
            System.out.println("There is no room at " + direction);
        }
    }
}
