public abstract class Entity {
    protected String name;
    protected int life;
    protected int shield;

    //MÉTODOS GERAIS:

    public Entity(String name, int life, int shield){
        this.life=life;
        this.name=name;
        this.shield=shield;
    }

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
