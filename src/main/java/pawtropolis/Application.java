package pawtropolis;

import pawtropolis.game.GameController;
public class Application {

    public static void main(String[] args) {
        GameController.getIstance().runGame();
     }
}