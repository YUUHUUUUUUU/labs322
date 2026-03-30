public class CardEffect extends Card{
    private Effect effect;
    
    //construct
    public CardEffect(String name, String description, int cost, Effect effect){
        super(name, description, cost);
        this.effect=effect;
    }

    //use the card during battle
    public void use(Entity user, Entity opponent){
        System.out.println(user.getName() + " used " + this.getName());
        System.out.println("");
    }

    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.effect.useDescription() + ")");
    }
}