import java.util.ArrayList;

public class Publisher{
    private ArrayList<Effect> effects;
    Entity target;

    Publisher(Entity target){
        this.target = target;
    }

    public void subscribe(Effect effect){
        Effect effectCopy = effect.copy();
        effects.add(effectCopy);
    }

    public void unsubscribe(Effect effect){//maybe we should destroy the effect to avoid memory leak
        effects.remove(effect);
    }

    public void notify(Effect effect){
        effect.use(this.target);
        if(effect.getDuration() == 0)unsubscribe(effect);
    }

    public void updateAll(){
        for(Effect effect : effects){
            notify(effect);
        }
    }

}
