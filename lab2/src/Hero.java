import java.util.ArrayList;

public class Hero extends Entity {
    private String name;
    private int life;
    private int shield;
    private int energy;
    private int regeneration;
    private ArrayList<Card> hand = new ArrayList<Card>();

    //construct
    public Hero(String name, int life, int shield, int energy, int regeneration, ArrayList<Card> hand){

        super(name,life,shield);

        this.life=life;
        this.name=name;
        this.shield=shield;
        this.energy=energy;
        this.regeneration=regeneration;
        this.hand=hand;
    }

    //lógica de recebimento de dano, o jogador sempre toma ao menos um de dano
    public void receiveDamage(int damage){
        this.life-=Math.max(1,damage-this.shield);
    }

    //ganhando escudo
    public void increaseShield(int shield){
        this.shield+=shield;
    }

    //altera a energia
    public void alteraEnergy(int cost){
        this.energy-=cost;
    }

    public int getEnergy(){
        return this.energy;
    }

    //posta status do heroi
    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
        System.out.println("Energy: " + this.energy);
    }

    public void setShield(int value){
        this.shield=value;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getRegeneration(){
        return this.regeneration;
    }

    //de fato regenera a energia do herói
    public void regenera(){
        this.energy+=this.regeneration;
    }

    //DECK OF CARDS:
    public ArrayList<Card> gethandDeck(){
        return this.hand;
    }
}