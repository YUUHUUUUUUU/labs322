
import java.util.ArrayList;

/**
 * Gerencia a lista de efeitos ativos (buffs ou debuffs) de uma entidade.
 * Implementa o padrão Observer para processar, aplicar e limpar os efeitos 
 * no início ou fim de cada turno.
 */
public class Publisher{
    private ArrayList<Effect> effects = new ArrayList<Effect>();
    Entity target;

    /**
     * Construtor do gerenciador de eventos.
     * @param target A entidade à qual este publicador pertence e onde os efeitos serão aplicados.
     */
    Publisher(Entity target){
        this.target = target;
    }

    /**
     * Inscreve um novo efeito à lista de ativos.
     * Nota: Cria uma cópia do efeito para garantir que a carta base original não seja alterada.
     * @param effect O efeito base a ser adicionado.
     */
    public void subscribe(Effect effect){
        Effect effectCopy = effect.copy();
        effects.add(effectCopy);
    }

    /**
     * Desinscreve um efeito da lista de ativos.
     * @param effect O efeito a ser removido.
     */
    public void unsubscribe(Effect effect){
        effects.remove(effect);
    }

    public void applyEffect(Effect effect){
        effect.use(this.target);
        if(effect.getDuration() == 0)unsubscribe(effect);
    }

    public void updateAll(){

        ArrayList<Effect> copy = new ArrayList<>(effects);

        for(Effect effect : copy){
            applyEffect(effect);
        }
    }

}
