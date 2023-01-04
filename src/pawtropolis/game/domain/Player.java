package pawtropolis.game.domain;

public class Player {

    private String name;
    private int healthPoints;
    private Bag playerBag = new Bag(1);

    public Player(String name){
        this.name = name;
    }

    public Player(String name,Bag playerBag){
        this.name = name;
        this.playerBag = playerBag;
    }

    public Bag getPlayerBag() {
        return playerBag;
    }

    public void setPlayerBag(Bag playerBag) {
        this.playerBag = playerBag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}