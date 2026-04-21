import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class EntityTest {

    @Test
    public void damageAbsorbedbyShieldHero() {
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(8);
        assertEquals(17, h.getLife());
        Enemy e = new Enemy("joao",20,5,4,3,null);
        e.receiveDamage(3);
        assertEquals(19,e.getLife());

    }

    @Test
    public void damageLessThanShieldHero() {
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(4);
        assertEquals(19,h.getLife());
    }

    @Test
    public void killingDamageHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(26);
        assertEquals(false,h.isAlive());
    }

    @Test
    public void gettersHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        assertEquals(4,h.getEnergy());
        assertEquals(3,h.getEnergyRegeneration());
        assertEquals("ruas",h.getName());
    }

    @Test
    public void settersHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.setName("joao");
        assertEquals("joao",h.getName());
        h.setShield(3);
        assertEquals(3,h.getShield());
    }

    @Test
    public void increaseShieldHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.increaseShield(2);
        assertEquals(7,h.getShield());
        h.increaseShield(-8);
        assertEquals(0,h.getShield());
    }

    @Test
    public void receiveDirectDamageHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDirectDamage(3);
        assertEquals(17,h.getLife());

    }

    @Test
    public void energyFunctionsHero(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.subtractEnergy(2);
        h.regenerate();
        assertEquals(5,h.getEnergy());
        h.subtractEnergy(100);
        assertEquals(0,h.getEnergy());
    }

    @Test
    public void gettingDeckHero(){
        ArrayList<Card> hand_hero = new ArrayList<Card>();
        Deck deck_hero = new Deck(hand_hero);
        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        deck_hero.getHand().add(espada);
        Hero h = new Hero("ruas",20,5,4,3,deck_hero);
        assertEquals("Espada",h.getDeck().getHand().get(0).getName());
    }

}
