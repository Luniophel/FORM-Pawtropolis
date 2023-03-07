package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.console.InputController;
import pawtropolis.map.MapController;
import pawtropolis.map.domain.Direction;

import java.util.List;
@Component
public class GoCommand implements Command{
    @Autowired
    MapController mc;

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
