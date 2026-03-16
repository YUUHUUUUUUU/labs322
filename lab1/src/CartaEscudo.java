public class CartaEscudo {
    private String name;
    private int custo;
    private int escudo;

    //construct
    public CartaEscudo(String name, int custo, int escudo){
    this.name=name;
    this.custo=custo;
    this.escudo=escudo;
    }

    //usa a carta durante a batalha
    public void usar(Heroi heroi){
        heroi.ganharEscudo(this.escudo);
        heroi.alteraEnergia(this.custo);
        System.out.println("Used " + this.name);
        System.out.println(heroi.getName() + " gained " + this.escudo + " shield!");
    }

    //mostra status da carta
    public void showStatus(){
        System.out.println(this.name + " (" + this.escudo + " defense, -" + this.custo + " energy)");
    }

    //custo da carta
    public int getCusto(){
        return this.custo;
    }
}
