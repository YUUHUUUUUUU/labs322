
public class Heroi {
    private String name;
    private int life;
    private int escudo;
    private int energia;
    private int regeneracao;

    //construct
    public Heroi(String name, int life, int escudo, int energia, int regeneracao){
        this.name=name;
        this.life=life;
        this.escudo=escudo;
        this.energia=energia;
        this.regeneracao=regeneracao;
    }

    //lógica de recebimento de dano, o jogador sempre toma ao menos um de dano
    public void receberDano(int dano){
        this.life-=Math.max(1,dano-escudo);
    }

    //ganhando escudo
    public void ganharEscudo(int escudo){
        this.escudo+=escudo;
    }

    //getEscudo
    public int getEscudo(){
        return this.escudo;
    }

    //altera a energia
    public void alteraEnergia(int custo){
        this.energia-=custo;
    }

    public int getEnergia(){
        return this.energia;
    }

    public boolean estaVivo(){
        return (this.life>0); 
    }

    //posta status do heroi
    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
        System.out.println("Energy: " + this.energia);
    }

    public void setShield(int value){
        this.escudo=value;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public int getRegeneracao(){
        return regeneracao;
    }

    //de fato regenera a energia do herói
    public void regenera(){
        this.energia+=this.regeneracao;
    }

}
