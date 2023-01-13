package pawtropolis.game.domain;

public class Player {

    static final int DEFAULT_BAG_SIZE = 10;

    private String name;
    private int healthPoints;
    private Bag bag = new Bag(DEFAULT_BAG_SIZE);

    public Player(String name){
        this.name = name;
    }

    public Player(String name,Bag bag){
        this.name = name;
        this.bag = bag;
    }

    public Item getItemByName(String itemName){
        return bag.getItemIfPresent(itemName);
    }

    public void removeItemFromBag(Item item){
        bag.removeItem(item);
    }

    public boolean addItemToBag(Item item){
        return bag.addItem(item);
    }

    public void lookIntoBag(){
        bag.showInfo();
    }
    //GETTER & SETTER

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