import java.util.ArrayList;
import java.util.Collections;

public class StandardHeroDeck extends Deck{

    public StandardHeroDeck(){
        CardFactory factory = new CardFactory();
        ArrayList<Card> shop = this.getShop();

        shop.add(factory.getCard("Ruler"));
        shop.add(factory.getCard("Pencil"));
        shop.add(factory.getCard("Eraser"));

        shop.add(factory.getCard("Excused Absence"));
        shop.add(factory.getCard("Doctor's Note"));
        shop.add(factory.getCard("Exam Exemption"));
        shop.add(factory.getCard("Summer Break"));

        shop.add(factory.getCard("Coffe"));
        
        Collections.shuffle(shop);
    }

}