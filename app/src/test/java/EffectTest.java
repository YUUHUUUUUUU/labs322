import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class EffectTest {
    
    @Test
    public void effect_test(){
        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);
        Effect poison = new PoisonEffect("Poison", "Strong Poison", 2, 4);
        Effect endurecimento_permanente = new ShieldEffect("Permanent rigid skin", "For 5 rounds, the creature maintains a shield of strength 4", 5, 4);

        assertEquals("Regenerates Energy", energyBuff.getDescription());
        assertEquals("Energy Buff", energyBuff.getName());
        assertEquals(3,energyBuff.getDuration());
        assertEquals(3,energyBuff.getIntensity());
        assertEquals(true,energyBuff.getIsBuff());
        assertEquals(false,poison.getIsBuff());

        energyBuff.reduceDuration();
        assertEquals(2,energyBuff.getDuration());
        
        Hero hero = new Hero("Nome", 25, 0, 5,4,1, null);
        energyBuff.subscribe(hero);
    }

    @Test
    public void cardeffect_test(){
        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);
        Effect poison = new PoisonEffect("Poison", "Strong Poison", 2, 4);
        Effect endurecimento_permanente = new ShieldEffect("Permanent rigid skin", "For 5 rounds, the creature maintains a shield of strength 4", 5, 4);
        
        CardEffect poisonCard = new CardEffect("poison", "Strong Poison", 5, poison);
        CardEffect energyRegenCard = new CardEffect("energy buff", "regenerates energy", 4, energyBuff);
        CardEffect shieldIncreaseCard = new CardEffect ("shield buff", "increases shield",5,endurecimento_permanente);
        
        // Instanciação das entidades hero e enemy
        Hero hero = new Hero("Nome", 25, 0, 5,4,1, null);
        Enemy enemy = new Enemy("IFGW", 20, 0,7,3,1,null);

        energyBuff.use(hero);
        assertEquals(8,hero.getEnergy());

        poison.use(hero);
        assertEquals(21,hero.getLife());

        endurecimento_permanente.use(hero);
        assertEquals(4,hero.getShield());

        poisonCard.use(hero,enemy);
        energyRegenCard.use(enemy,hero);
        shieldIncreaseCard.use(hero,enemy);
    }

    @Test
    public void effects_copy_description(){
        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);
        Effect poison = new PoisonEffect("Poison", "Strong Poison", 2, 4);
        Effect endurecimento_permanente = new ShieldEffect("Permanent rigid skin", "For 5 rounds, the creature maintains a shield of strength 4", 5, 4);
    
        Effect e1 = energyBuff.copy();
        Effect e2 = poison.copy();
        Effect e3 = endurecimento_permanente.copy();

        assertEquals("+3 energy at the start of the next 3 rounds",e1.useDescription());
        assertEquals("-4 life at the start of the next 2 rounds",e2.useDescription());

        assertEquals("+4 shield at the beginning of the next 5 rounds",e3.useDescription());

    }
        


}
    //testar Effect (construct, getters, subscribe,reduceDuration)v, PoisonEffect/EnergyEffect/ShieldEffect (Construct,Use,Copy,Usedescription), CardEffect(Construct,Use).

