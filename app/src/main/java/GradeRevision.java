
public class GradeRevision extends Event{
    private Hero hero;

    GradeRevision(Hero hero){
        this.hero = hero;
    }

    public void begin(){
        //implement the RNG and change life by +/- 20hp
    }
}
