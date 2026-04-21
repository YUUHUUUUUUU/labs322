import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CardTest {
    
    @Test
    public void getters(){
        CardDamage c = new CardDamage("fogo", "Dano médio", 3,5);
        CardShield c1 = new CardShield("escudo", "Proteção média", 4,6);
        assertEquals(3,c.getCost());
        assertEquals("Proteção média", c1.getDescription());
        assertEquals("fogo",c.getName());
    }


    @Test
    public void using(){
        CardDamage c = new CardDamage("fogo", "Dano médio", 3,5);
        CardShield c1 = new CardShield("escudo", "Proteção média", 4,6);

        ArrayList<Card> hand_hero = new ArrayList<Card>();
        ArrayList<Card> hand_enemy = new ArrayList<Card>();

        Deck deck_hero = new Deck(hand_hero);
        Deck deck_enemy = new Deck(hand_enemy);

        Hero h = new Hero("ruas",20,4,4,3,1,deck_hero);
        Enemy e = new Enemy("joao",20,4,4,3,1,deck_enemy);

        deck_hero.getHand().add(c);
        deck_hero.getHand().add(c1);
        deck_enemy.getHand().add(c);
        deck_enemy.getHand().add(c1);

        c.use(h,e);
        assertEquals(19,e.getLife());

        e.setShield(0);
        assertEquals(0,e.getShield());

        c1.use(e,h);
        c.use(h,e);//vida de e vira 18 e escudo vira 1
        e.setShield(1);
        c.use(h,e);
        assertEquals(14,e.getLife());
        
    }
    
}
