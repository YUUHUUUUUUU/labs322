public abstract class Carta{
    private String name;
    private String description;
    private int cost;
    
    //construct
    public Carta(String name, String description, int cost){
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    //usa a carta durante a batalha
    public abstract void usar(Inimigo inimigo, Heroi heroi);

    //mostra dados da carta
    public abstract void showDescription();

    //custo da carta
    public int getCost(){
        return this.cost;
    }
}
