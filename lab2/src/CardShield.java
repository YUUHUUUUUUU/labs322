public class CardShield extends Card{
    private int shield;

    //construct
    public CardShield(String name, String description, int cost, int shield){
        super(name,description,cost);
        this.shield=shield;
    }

    //usa a carta durante a batalha
    public void usar(Enemy enemy, Hero hero){
        hero.increaseShield(this.shield);
        System.out.println("Used " + this.getName());
        System.out.println(hero.getName() + " gained " + this.shield + " shield!");
        System.out.println("");
    }

    //mostra status da carta
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.shield + " defense, -" + this.getCost() + " energy)");
    }

}
