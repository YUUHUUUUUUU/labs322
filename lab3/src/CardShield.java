public class CardShield extends Card {
    private int shield;

    //construct
    public CardShield(String name, String description, int cost, int shield){
        super(name,description,cost);
        this.shield=shield;
    }

    //use the card during combat
    public void use(Entity user, Entity opponent){
        user.increaseShield(this.shield);
        //hero.alteraEnergy(this.cost);
        System.out.println("Used " + this.getName());
        System.out.println(user.getName() + " gained " + this.shield + " shield!");
        System.out.println("");
    }

    //mostra status da carta
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.shield + " defense, -" + this.getCost() + " energy)");
    }

    //custo da carta
    public int getCusto(){
        return this.getCost();
    }
}
