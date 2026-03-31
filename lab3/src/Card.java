public abstract class Card{
    private String name;
    private String description;
    private int cost;
    
    //construct
    public Card(String name, String description, int cost){
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    //use the card during the battle
    public abstract void use(Entity user, Entity opponent);

    //show card description
    public abstract void showDescription();

    public int getCost(){
        return this.cost;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
