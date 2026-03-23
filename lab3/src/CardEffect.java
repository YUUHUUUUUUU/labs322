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

    //usa a carta durante a batalha
    public void usar(Enemy enemy, Hero hero){
        enemy.receiveDamage(this.damage);
        //hero.alteraEnergy(this.cost);
        System.out.println(hero.getName() + " used " + this.name);
        //System.out.println(hero.getName() + " lost " + this.cost + " energy!"); nao precisa mais
        System.out.println(enemy.getName() + " lost " + this.damage + " life!");
        System.out.println("");
    }

    //mostra dados da carta
    // public void showDescription(){
    //     System.out.println(this.name + ", " + this.description + " (" + this.effect + " damage, -" + this.cost + " energy)");
    // }
}