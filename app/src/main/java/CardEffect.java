/**
 * Uma carta que serve para aplicar efeitos. Ela pode tanto aplicar
 * buffs no user quanto debuffs no oponente.
 */
public class CardEffect extends Card{
    private Effect effect;
    
    /**
     * Construtor para inicializar uma carta de efeito.
     * @param name O nome da carta.
     * @param description A descrição do que a carta faz.
     * @param cost O custo de energia necessário para comprar a carta.
     * @param effect O efeito (buff ou debuff) associado à carta.
     */
    public CardEffect(String name, String description, int cost, Effect effect){
        super(name, description, cost);
        this.effect=effect;
    }

    /**
     * Usa a carta durante a batalha, aplicando o efeito em si mesmo se
     * for um buff ou no oponente se for um debuff.
     * @param user A entidade que está usando a carta.
     * @param opponent A entidade que receberá o ataque e possíveis efeitos.
     */
    @Override
    public void use(Entity user, Entity opponent){
        if(effect.getIsBuff())effect.subscribe(user);
        else effect.subscribe(opponent);
        System.out.println(user.getName() + " used " + this.getName());
        System.out.println("");
    }

    /**
     * Exibe as informações detalhadas da carta de efeito, incluindo nome,
     * descrição base da carta, descrição do efeito e custo de energia.
     */
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.effect.useDescription() + ", -" + this.getCost() + " energy" + ")");
    }
}