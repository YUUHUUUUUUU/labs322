/**
 * Representa uma carta de ataque no jogo.
 * Além de causar dano direto ao oponente, pode opcionalmente aplicar 
 * um efeito de debuff.
 */
public class CardDamage extends Card{
    private int damage;
    private Effect effect = null;
    
    /**
     * Construtor para uma carta de dano simples, sem efeitos adicionais.
     * @param name O nome da carta.
     * @param description A descrição do ataque.
     * @param cost O custo de energia para comprar a carta.
     * @param damage A quantidade de dano que a carta dá.
     */
    public CardDamage(String name, String description, int cost, int damage){
        super(name, description, cost);
        this.damage=damage;
    }

    /**
     * Construtor para uma carta de dano com debuff.
     * @param name O nome da carta.
     * @param description A descrição do ataque.
     * @param cost O custo de energia para comprar a carta.
     * @param damage A quantidade de dano que a carta dá.
     * @param effect O debuff aplicado ao usar a carta.
     */
    public CardDamage(String name, String description, int cost, int damage, Effect effect){//makes it possible for a cardDamage to inflict a debuff
        super(name, description, cost);
        this.damage=damage;
        this.effect = effect;
    }

    /**
     * Usa a carta durante a batalha, aplica o dano e, se a carta possuir um
     * efeito, o aplica no oponente.
     * @param user A entidade que está usando a carta.
     * @param opponent A entidade que receberá o ataque e possíveis efeitos.
     */
    @Override
    public void use(Entity user, Entity opponent){
        int finalDamage = (int) (damage * user.getDamageMultiplier());
        finalDamage = (finalDamage/5)*5;
        opponent.receiveDamage(finalDamage);
        System.out.println(user.getName() + " used " + this.getName());
        System.out.println(opponent.getName() + " lost " + Math.max(finalDamage-opponent.getShield(),1) + " life!");
        if(effect != null){
            effect.subscribe(opponent);
            System.err.println(opponent.getName() + " was inflicted with " + effect.getName() + " (" + effect.useDescription() + ")");
        }
        System.out.println("");
    }

    /**
     * Exibe as informações detalhadas da carta de dano, incluindo nome,
     * descrição, valor do dano e custo de energia.
     */
    @Override
    public void showDescription(){
        System.out.println(this.getName() + ", " + this.getDescription() + " (" + this.damage + " base damage, -" + this.getCost() + " energy)");
    }
}