package pawtropolis.command.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

import java.util.List;
@Component
public class LookCommand implements Command{
    @Autowired
    GameController gameController;
    public void execute(List<String> tokens){
        gameController.showRoomInfo();
    }
}

