public class Inimigo {
    private String name;
    private int life;
    //private int escudo;
    //private int energia;
    private int dano_padrao;

    //construct, resolvemos tirar o escudo e a energia do inimigo por so complicarem inicialmente
    public Inimigo(String name, int life, int escudo, int dano_padrao){
        this.name=name;
        this.life=life;
        //this.escudo=escudo;
        //this.energia=energia;
        this.dano_padrao=dano_padrao;
    }

    //toma dano do herói de acordo com o parâmetro da arma do herói
    public void receberDano(int dano){
        this.life-=dano;
    }

    //ataca o herói com dano padrao
    public void atacar(Heroi heroi){
        heroi.receberDano(this.dano_padrao);
    }

    // public void alteraEnergia(int custo){
    //     this.energia-=custo;
    // }

    public boolean estaVivo(){
        return (this.life>0);
    }

    public String getName(){
        return this.name;
    }

    public int getLife(){
        return this.life;
    }

    public int getDano(Heroi heroi){
        return Math.max(this.dano_padrao-heroi.getEscudo(),1);
    }

    //mostra o status do inimigo

    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
    }

}
