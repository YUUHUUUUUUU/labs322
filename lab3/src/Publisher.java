import java.util.ArrayList;

public class Publisher {
    private ArrayList<Effect> list;

    public void subscribe(Effect effect){
        list.add(effect);
    }

    public void desubscribe(Effect effect){
        list.remove(effect);
    }

    public void notify(Effect effect, Entity entity){
        effect.use(entity);
    }

}
