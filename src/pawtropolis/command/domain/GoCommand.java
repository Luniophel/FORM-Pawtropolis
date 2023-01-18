package pawtropolis.command.domain;

import pawtropolis.game.GameController;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Room;

import java.util.List;

public class GoCommand extends Command{

    @Override
    public void execute(List<String> tokens) {
        Direction direction = Direction.dir(tokens.get(1));
        if(direction == Direction.INVALID) {
            System.out.println("Invalid direction");
        }
        Room targetRoom = GameController.getIstance().getCurrentRoom().getRoomAtDirection(direction);
        if (targetRoom == null) {
            System.out.println("There is no room at " + direction);

        } else {
            GameController.getIstance().getMapController().changeRoom(direction);
            GameController.getIstance().getCurrentRoom().showInfo();
        }
    }
}
