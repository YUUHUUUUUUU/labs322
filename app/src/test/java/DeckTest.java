import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class DeckTest {

    @Test
    public void getters(){

        Effect mordidaVeneno = new PoisonEffect("Poisoned bite", "Poison present in the creature's teeth",2,3);
        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);

        CardDamage c = new CardDamage("fogo", "Dano médio", 3,5);
        CardShield c1 = new CardShield("escudo", "Proteção média", 4,6);
        CardDamage garra = new CardDamage("Garra", "Strong attack", 6,8);
        CardDamage mordida_venenosa = new CardDamage("Mordida Venenosa", "Medium attack, but with poison that infects the opponent", 7, 7,mordidaVeneno);
        CardDamage tapa_e_energia = new CardDamage("Da tapa no oponente e recupera energia","Weak attack adding energy to you",2, 3,energyBuff);


        ArrayList<Card> hand_hero = new ArrayList<Card>();
        ArrayList<Card> hand_enemy = new ArrayList<Card>();

        Deck deck_hero = new Deck(hand_hero);
        Deck deck_enemy = new Deck(hand_enemy);

        Hero h = new Hero("ruas",20,4,4,3,deck_hero);
        Enemy e = new Enemy("joao",20,4,4,3,deck_enemy);

        deck_hero.getHand().add(c);
        deck_hero.getHand().add(c1);
        deck_enemy.getHand().add(c);
        deck_enemy.getHand().add(c1);
        deck_hero.getShop().add(garra);
        deck_hero.getTrash().add(mordida_venenosa);

        assertEquals("fogo",deck_hero.getHand().get(0).getName());
        assertEquals("Garra",deck_hero.getShop().get(0).getName());
        assertEquals("Mordida Venenosa",deck_hero.getTrash().get(0).getName());
        deck_hero.shuffleShop();
        assertEquals(6,deck_hero.getShop().get(0).getCost());
        mordida_venenosa.use(h,e);
        tapa_e_energia.use(h,e);
    }
}
