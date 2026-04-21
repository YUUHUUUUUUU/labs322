
/**
 * Representa uma carta de defesa no jogo.
 * Quando utilizada, aumenta os pontos de escudo (proteção) da entidade 
 * que a jogou, ajudando a mitigar o dano de ataques inimigos.
 */
public class CardShield extends Card {
    private int shield;

    /**
     * Construtor para inicializar uma carta de escudo.
     *
     * @param name O nome da carta.
     * @param description A descrição da carta.
     * @param cost O custo de energia necessário para comprar a carta.
     * @param shield A quantidade de pontos de escudo que a carta dá.
     */
    public CardShield(String name, String description, int cost, int shield){
        super(name,description,cost);
        this.shield=shield;
    }

    /**
     * Usa a carta durante a batalha, dando pontos de escudo por uma
     * rodada à entidade que usou a carta.
     * @param user A entidade que está usando a carta e receberá o escudo.
     * @param opponent A entidade adversária (não é necessária para essa classe
     * mas é pedida na chamada da classe Card)
     */
    @Override
    public void use(Entity user, Entity opponent){
        user.increaseShield(this.shield);
        System.out.println("Used " + this.getName());
        System.out.println(user.getName() + " gained " + this.shield + " shield!");
        System.out.println("");
    }

    /**
     * Exibe as informações detalhadas da carta de escudo,
     * incluindo o nome, descrição, valor do escudo e custo de energia.
     */
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.shield + " defense, -" + this.getCost() + " energy)");
    }
}