public class CardDamage extends Card{
    private String name;
    private int cost;
    private int damage;
    private String description;
    
    //construct
    public CardDamage(String name, String description, int cost, int damage){
        super(name, description, cost);
        this.damage=damage;
    }

    //usa a carta durante a batalha
    public void usar(Enemy enemy, Hero hero){
        enemy.receiveDamage(this.damage);
        hero.alteraEnergy(this.cost);
        System.out.println("Used " + this.name);
        System.out.println(hero.getName() + " lost " + this.cost + " energy!");
        System.out.println(enemy.getName() + " lost " + this.damage + " life!");
    }

    //mostra dados da carta
    public void showDescription(){
        System.out.println(this.name + " (" + this.damage + " damage, -" + this.cost + " energy)");
    }
}
