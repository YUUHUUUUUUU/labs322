public class CardEffect extends Card{
    private String name;
    private int cost;
    private Effect effect;
    private String description;
    
    //construct
    public CardEffect(String name, String description, int cost, Effect effect){
        super(name, description, cost);
        this.name=name;
        this.description=description;
        this.effect=effect;
        this.cost=cost;
    }

    //use the card during battle
    public void use(Entity user, Entity opponent){
        System.out.println(user.getName() + " used " + this.name);
        System.out.println("");
    }

    public void showDescription(){
        System.out.println(this.name + ", " + this.description + " (" + this.effect + " damage, -" + this.cost + " energy)");
    }
}