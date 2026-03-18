public class CardDamage extends Card{
    private String name;
    private int cost;
    private int damage;
    private String description;
    
    //construct
    public CardDamage(String name, String description, int cost, int damage){
        super(name, description, cost);
        this.name=name;
        this.damage=damage;
        this.cost=cost;
        this.damage=damage;
    }

    //usa a carta durante a batalha
    public void usar(Enemy enemy, Hero hero){
        enemy.receiveDamage(this.damage);
        //hero.alteraEnergy(this.cost); nao precisa mais
        System.out.println(hero.getName() + " used " + this.name);
        //System.out.println(hero.getName() + " lost " + this.cost + " energy!"); nao precisa mais
        System.out.println(enemy.getName() + " lost " + this.damage + " life!");
        System.out.println("");
    }

    //mostra dados da carta
    public void showDescription(){
        System.out.println(this.name + " (" + this.damage + " damage, -" + this.cost + " energy)");
    }
}
