package pawtropolis.game.domain;

public class Player {

    private String name;
    private int healthPoints;
    private Bag bag = new Bag(1);

    public Player(String name){
        this.name = name;
    }

    public Player(String name,Bag bag){
        this.name = name;
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
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