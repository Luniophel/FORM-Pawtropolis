package pawtropolis;

import pawtropolis.game.GameController;
import pawtropolis.game.domain.Player;
public class Application {

    public static void main(String[] args) {
        GameController.getIstance().runGame();
     }
}