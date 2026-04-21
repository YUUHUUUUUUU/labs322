
public class CardDamage extends Card{
    private int damage;
    private Effect effect = null;
    
    //construct
    public CardDamage(String name, String description, int cost, int damage){
        super(name, description, cost);
        this.damage=damage;
    }
    public CardDamage(String name, String description, int cost, int damage, Effect effect){//makes it possible for a cardDamage to inflict a debuff
        super(name, description, cost);
        this.damage=damage;
        this.effect = effect;
    }

    //usa a carta durante a batalha
    public void use(Entity user, Entity opponent){
        int finalDamage = (int) (damage * user.getDamageMultiplier());
        finalDamage = (finalDamage/5)*5;
        opponent.receiveDamage(finalDamage);
        System.out.println(user.getName() + " used " + this.getName());
        System.out.println(opponent.getName() + " lost " + Math.max(finalDamage-opponent.getShield(),1) + " life!");
        if(effect != null){
            effect.subscribe(opponent);
            System.err.println(opponent.getName() + " was inflicted with " + effect.getName() + " (" + effect.useDescription() + ")");
        }
        System.out.println("");
    }

    //mostra dados da carta
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.damage + " base damage, -" + this.getCost() + " energy)");
    }
}