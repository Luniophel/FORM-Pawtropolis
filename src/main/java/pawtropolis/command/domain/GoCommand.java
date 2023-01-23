package main.java.pawtropolis.command.domain;

import main.java.pawtropolis.game.GameController;
import main.java.pawtropolis.game.console.InputController;
import main.java.pawtropolis.map.MapController;
import main.java.pawtropolis.map.domain.Direction;

import java.util.List;

public class GoCommand implements Command{
    GameController gc = GameController.getIstance();
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
