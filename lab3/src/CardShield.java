public class CardShield extends Card {
    private String name;
    private int cost;
    private int shield;
    private String description;

    //construct
    public CardShield(String name, String description, int cost, int shield){
        super(name,description,cost);
        this.description=description;
        this.name=name;
        this.cost=cost;
        this.shield=shield;
    }

    //use the card during combat
    public void use(Entity user, Entity opponent){
        user.increaseShield(this.shield);
        //hero.alteraEnergy(this.cost);
        System.out.println("Used " + this.name);
        System.out.println(user.getName() + " gained " + this.shield + " shield!");
        System.out.println("");
    }

    //mostra status da carta
    public void showDescription(){
        System.out.println(this.name + ", " + this.description + " (" + this.shield + " defense, -" + this.cost + " energy)");
    }

    //custo da carta
    public int getCusto(){
        return this.cost;
    }
}
