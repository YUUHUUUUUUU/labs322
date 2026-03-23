public abstract class Card{
    private String name;
    private String description;
    private int cost;
    
    //construct
    public Card(String name, String description, int cost){
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    //usa a carta durante a batalha
    public abstract void usar(Enemy enemy, Hero hero);

    //mostra dados da carta
    public abstract void showDescription();

    //custo da carta
    public int getCost(){
        return this.cost;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
