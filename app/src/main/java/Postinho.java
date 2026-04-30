
public class Postinho extends Event{
    private Hero hero;

    Postinho(Hero hero){
        this.hero = hero;
    }

    public void begin(){
        
        System.out.println("You just entered Postinho! A place where students hide from IFGW and rest with magic potions, usually in Thursdays");

        hero.receiveDamage(-50);
        hero.regenerate();

        System.out.println("You recovered 50 life points and the default energy regeneration!");
    }
}
