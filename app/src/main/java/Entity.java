
public abstract class Entity {
    private String name;
    private int life;
    private int shield;
    private int energy;
    private int energyRegeneration;
    private Publisher beginningPublisher = new Publisher(this);
    private Publisher endPublisher = new Publisher(this);
    private Deck deck;
    private double damageMultiplier;

    //constructor
    public Entity(String name, int life, int shield, int energy, int energyRegeneration, double damageMultiplier, Deck deck){
        this.name = name;
        this.life = life;
        this.shield = shield;
        this.energy = energy;
        this.energyRegeneration = energyRegeneration;
        this.damageMultiplier = damageMultiplier;
        this.deck = deck;
    }

    //name methods
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    //life methods
    public int getLife(){
        return this.life;
    }
    public boolean isAlive(){
        return (this.life>0); 
    }
    public void receiveDamage(int damage){
        this.life-=Math.max(1,damage-this.shield);
    }
    public void receiveDirectDamage(int damage){//for damages not blocked by shield, such as poison damage
        this.life-=damage;
    }
    public void setLife(int life){
        this.life = life;
    }

    //shield methods
    public void setShield(int value){
        this.shield=value;
    }
    public int getShield(){
        return this.shield;
    }
    public void increaseShield(int value){
        this.shield += value;
    }
    
    //publisher methods
    public Publisher getBegginningPublisher(){
        return this.beginningPublisher;
    }
    public Publisher getEndPublisher(){
        return this.endPublisher;
    }

    //energy methods
    public int getEnergy(){
        return this.energy;
    }
    public void subtractEnergy(int value){
        this.energy-=value;
    }
    public void regenerate(){
        this.energy+=this.energyRegeneration;
    }
    public int getEnergyRegeneration(){
        return this.energyRegeneration;
    }
    public void setEnergyRegeneration(int energyRegeneration){
        this.energyRegeneration = energyRegeneration;
    }

    //damageMultiplier methods
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
    

    public Deck getDeck(){
        return this.deck;
    }

    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
        System.out.println("Energy: " + this.energy);
    }
}
