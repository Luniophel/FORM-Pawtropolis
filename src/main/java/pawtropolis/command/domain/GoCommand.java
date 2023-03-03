package pawtropolis.command.domain;

import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Direction;

import java.util.List;

public class GoCommand implements Command{
    GameController gc = GameController.getInstance();
    MapController mc = gc.getMapController();

    @Override
    public void execute(List<String> tokens) {
        Direction direction = Direction.of(InputController.getParameters(tokens));
        if(direction == Direction.INVALID) {
            System.out.println("Invalid direction");
        }
        if (mc.isRoomAtDirection(direction)) {
            mc.changeRoom(direction);
            mc.getCurrentRoom().showInfo();
        } else {
            System.out.println("There is no room at " + direction);
        }
    }
}
