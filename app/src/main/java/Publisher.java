
import java.util.ArrayList;

public class Publisher{
    private ArrayList<Effect> effects = new ArrayList<Effect>();
    Entity target;

    Publisher(Entity target){
        this.target = target;
    }

    public void subscribe(Effect effect){
        Effect effectCopy = effect.copy();
        effects.add(effectCopy);
    }

    public void unsubscribe(Effect effect){
        effects.remove(effect);
    }

    public void notify(Effect effect){
        effect.use(this.target);
        if(effect.getDuration() == 0)unsubscribe(effect);
    }

    public void updateAll(){

        ArrayList<Effect> copy = new ArrayList<>(effects);

        for(Effect effect : copy){
            notify(effect);
        }
    }

}
