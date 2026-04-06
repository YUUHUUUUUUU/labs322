/**
 * Classe abstrata que gera as classes de carta especificas, com metodos abstratos
 */

public abstract class Card{
    private String name;
    private String description;
    private int cost;

    /**
     * esse é o construct da classe
     * @param name nome
     * @param description descricao
     * @param cost custo
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
     * classe abstrata que printa a descrição de cada carta
     */
    public abstract void showDescription();

    /**
     * 
     * @return o custo de uma carta
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * 
     * @return o nome da carta
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return a descrição da carta
     */
    public String getDescription(){
        return this.description;
    }
}
