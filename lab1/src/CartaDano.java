public class CartaDano {
    private String name;
    private int custo;
    private int dano;
    
    //construct
    public CartaDano(String name, int custo, int dano){
    this.name=name;
    this.custo=custo;
    this.dano=dano;
    }

    //usa a carta durante a batalha
    public void usar(Inimigo inimigo, Heroi heroi){
        inimigo.receberDano(this.dano);
        heroi.alteraEnergia(this.custo);
        System.out.println("Used " + this.name);
        System.out.println(heroi.getName() + " lost " + this.custo + " energy!");
        System.out.println(inimigo.getName() + " lost " + this.dano + " life!");
    }

    //mostra dados da carta
    public void showStatus(){
        System.out.println(this.name + " (" + this.dano + " damage, -" + this.custo + " energy)");
    }

    //custo da carta
    public int getCusto(){
        return this.custo;
    }
}
