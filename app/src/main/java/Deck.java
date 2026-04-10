import java.util.ArrayList;
import java.util.Collections;

/**
 * Gerencia os conjuntos de cartas (baralhos) de uma entidade durante o jogo.
 * Mantém o controle das cartas disponíveis para uso/compra (shop), 
 * da mão atual (hand) e da pilha de descarte (trash).
 */
public class Deck{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> trash = new ArrayList<Card>();
    private ArrayList<Card> shop = new ArrayList<Card>();

    /**
     * Construtor da classe Deck.
     * @param hand A lista que representará a mão da entidade. Passada por referência 
     * para permitir a sincronização depois de instanciado.
     */
    Deck(ArrayList<Card> hand){
        this.hand = hand;
    }

    /**
     * Getter das cartas que estão atualmente na mão da entidade.
     * @return A lista de cartas na mão.
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Getter das cartas que estão atualmente na fila de compra.
     * @return A lista de cartas na fila de compra.
     */
    public ArrayList<Card> getShop() {
        return shop;
    }

    /**
     * Getter das cartas que estão atualmente no lixo.
     * @return A lista de cartas no lixo.
     */
    public ArrayList<Card> getTrash() {
        return trash;
    }

    /**
     * Embaralha a ordem das cartas disponíveis na loja.
     */
    public void shuffleShop(){
        Collections.shuffle(shop);
    }
}
