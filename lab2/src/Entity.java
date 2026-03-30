public abstract class Entity{
    private String name;
    private int life;
    private int shield;

    public Entity(String name, int life, int shield){
        this.life=life;
        this.name=name;
        this.shield=shield;
    }

    //name methods
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    //shield methods
    public int getShield(){
        return this.shield;
    }
    public void setShield(int value){
        this.shield=value;
    }
    public void increaseShield(int shield){
        this.shield+=shield;
    }

    //life methods
    public int getLife(){
        return this.life;
    }
    public boolean isAlive(){
        return (this.life>0); 
    }
    public void subtractLife(int x){
        this.life -= x;
    }
    
    //ABSTRATCTS:

    public abstract void receiveDamage(int damage);

    public abstract void showStatus();
}
