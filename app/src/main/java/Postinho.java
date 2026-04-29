
public class Postinho extends Event{
    private Hero hero;

    Postinho(Hero hero){
        this.hero = hero;
    }

    public void begin(){
        //add some text here

        hero.receiveDamage(-50);
    }
}
