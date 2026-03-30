import java.util.ArrayList;

public class Hero extends Entity{
    private int energy;
    private int regeneration;
    private ArrayList<Card> hand = new ArrayList<Card>();

    //construct
    public Hero(String name, int life, int shield, int energy, int regeneration){

        super(name,life,shield);

        this.energy=energy;
        this.regeneration=regeneration;
    }

    //lógica de recebimento de dano, o jogador sempre toma ao menos um de dano
    public void receiveDamage(int damage){
        this.subtractLife(Math.max(1,damage-this.getShield()));
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
        System.out.println(this.getName() + " status:");
        System.out.println("Life: " + this.getLife());
        System.out.println("Energy: " + this.energy);
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