import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

public class Herotest {

    @Test
    public void damageAbsorbedbyShield() {
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(8);
        assertEquals(17, h.getLife());

    }

    @Test
    public void damageLessThanShield() {
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(4);
        assertEquals(19,h.getLife());
    }

    @Test
    public void killingDamage(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        h.receiveDamage(23);
        assertEquals(false,h.isAlive());
    }

    @Test
    public void getters(){
        Hero h = new Hero("ruas",20,5,4,3,null);
        assertEquals(4,h.getEnergy());
        assertEquals(3,h.getEnergyRegeneration());
        assertEquals("ruas",h.getName());
    }

}
