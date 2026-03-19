public abstract class Entity {
    private String name;
    private int life;
    private int shield;

    //MÉTODOS GERAIS:

    public Entity(String name, int life, int shield){
        this.life=life;
        this.name=name;
        this.shield=shield;
    } //tem algum erro aqui. quando atualizo o heroi, nao ta atualizando a entidade em si.
    // por isso as vezes ta aparecendo "Nome" no print ao inves do nome escolhido

    public String getName(){
        return this.name;
    }

    public int getLife(){
        return this.life;
    }

    public int getShield(){
        return this.shield;
    }

    public void setShield(int value){
        this.shield+=value;
    }

    public boolean isAlive(){
        return (this.life>0); 
    }

    //ABSTRATAS:

    public abstract void receiveDamage(int damage);

    public abstract void showStatus();

    //public abstract void shield();





}
