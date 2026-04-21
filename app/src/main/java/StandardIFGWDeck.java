import java.util.ArrayList;
import java.util.Collections;

public class StandardIFGWDeck extends Deck{

    public StandardIFGWDeck(){
        CardFactory factory = new CardFactory();
        ArrayList<Card> shop = this.getShop();

        shop.add(factory.getCard("Test"));
        shop.add(factory.getCard("Exam"));
        shop.add(factory.getCard("Final Exam"));
        shop.add(factory.getCard("Mercury Termometer"));

        shop.add(factory.getCard("Cancel Classes"));
        shop.add(factory.getCard("Public Servant Immunity"));
        shop.add(factory.getCard("Dash"));
        shop.add(factory.getCard("Dash"));

        shop.add(factory.getCard("Radium"));
        shop.add(factory.getCard("Coffe"));

        Collections.shuffle(shop);
    }
}