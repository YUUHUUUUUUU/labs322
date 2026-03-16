public class CartaDano extends Carta{
    private String name;
    private String description;
    private int cost;
    private int damage;
    
    //construct
    public CartaDano(String name, String description, int cost, int damage){
        super(name, description, cost);

        this.damage=damage;
    }

    //usa a carta durante a batalha
    public void usar(Inimigo inimigo, Heroi heroi){
        inimigo.receberDano(this.damage);
        heroi.alteraEnergia(this.cost);
        System.out.println("Used " + this.name);
        System.out.println(heroi.getName() + " lost " + this.cost + " energy!");
        System.out.println(inimigo.getName() + " lost " + this.damage + " life!");
    }

    //mostra dados da carta
    public void showDescription(){
        System.out.println(this.name + " (" + this.damage + " damage, -" + this.cost + " energy)");
    }
}
