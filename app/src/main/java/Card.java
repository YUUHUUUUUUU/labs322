/**
 * Representa uma carta de escudo no jogo.
 * Quando utilizada, aumenta os pontos de escudo da entidade 
 * que a jogou por uma rodada.
 */
public abstract class Card{
    private String name;
    private String description;
    private int cost;

    /**
     * Construtor padrão para inicializar os atributos básicos de uma carta.
     * @param name O nome da carta.
     * @param description O texto descritivo sobre o efeito ou lore da carta.
     * @param cost O custo de energia ou recurso necessário para jogá-la.
     */
    public Card(String name, String description, int cost){
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    /**
     * classe abstrata que dita como a carta é usada
     * @param user quem vai usar a carta
     * @param opponent em qual oponente irá usar? (vale a pena se formos ter mais de um)
     */
    public abstract void use(Entity user, Entity opponent);

    /**
     * Exibe a descrição detalhada da carta
     */
    public abstract void showDescription();

    /**
     * Getter para o custo da carta
     * @return o custo de uma carta
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * Getter para o nome da carta
     * @return o nome da carta
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter para a descrição da carta
     * @return a descrição da carta
     */
    public String getDescription(){
        return this.description;
    }
}
