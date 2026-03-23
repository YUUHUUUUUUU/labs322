public abstract class Entity {
    private String name;
    private int life;
    private int shield;
    private Publisher begin;
    private Publisher end;

    //MÉTODOS GERAIS:

    public Entity(String name, int life, int shield, Publisher begin, Publisher end){
        this.life=life;
        this.name=name;
        this.shield=shield;
        this.begin=begin;
        this.end=end;

    }

    public String getName(){
        return this.name;
    }

    public int getLife(){
        return this.life;
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

    public abstract int getShield();

    public Publisher getbeginPublisher(){
        return begin;
    }
    public Publisher getendPublisher(){
        return end;
    }

    //public abstract void shield();





}
