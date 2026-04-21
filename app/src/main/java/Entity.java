/**
 * Classe base abstrata que representa qualquer entidade no combate (Hero ou Enemy).
 * Gerencia os atributos principais das entidades: vida, escudo, energia,
 * o Deck e os Publishers.
 */
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

    /**
     * Construtor para inicializar os atributos da entidade.
     * @param name O nome da entidade.
     * @param life Os pontos de vida iniciais.
     * @param shield Os pontos de escudo iniciais.
     * @param energy A energia inicial disponível para jogar cartas.
     * @param energyRegeneration A quantidade de energia recuperada no fim de cada turno.
     * @param deck A instância do baralho associada a esta entidade.
     */
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
    /**
     * Verifica se a entidade ainda está viva.
     * @return true se a vida for maior que 0, false caso contrário.
     */
    public boolean isAlive(){
        return (this.life>0); 
    }
    /**
     * Aplica dano à entidade menos o valor atual do escudo.
     * O dano é fixado como pelo menos 1 independente do valor do escudo.
     * @param damage O valor bruto do dano recebido.
     */
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
        if (this.shield+value >= 0){
          this.shield += value;  
        } else {
            this.shield = 0;
        }

    }
    
    //publisher methods
    public Publisher getBeginningPublisher(){
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
        if(value>this.energy){
            this.energy=0;
        } else{
            this.energy-=value;
        }
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

    /**
     * Exibe o status atual de vida e energia da entidade.
     */
    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
        System.out.println("Energy: " + this.energy);
    }
}
