public class CardDamage extends Card{
    private int damage;
    
    public CardDamage(String name, String description, int cost, int damage){
        super(name, description, cost);
        this.damage=damage;
    }

    //usa a carta durante a batalha
    public void usar(Enemy enemy, Hero hero){
        enemy.receiveDamage(this.damage);
        //hero.alteraEnergy(this.cost);
        System.out.println(hero.getName() + " used " + this.getName());
        //System.out.println(hero.getName() + " lost " + this.cost + " energy!"); nao precisa mais
        System.out.println(enemy.getName() + " lost " + this.damage + " life!");
        System.out.println("");
    }

    //mostra dados da carta
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.damage + " damage, -" + this.getCost() + " energy)");
    }
}
