import org.junit.jupiter.api.Test;

public class CombatTest {
    @Test
    public void run_combat(){


        Hero h = new Hero("ruas",100000,4,4,3,1,new StandardHeroDeck());
        Enemy e = new Enemy("joao",20,4,4,3,1,new StandardIFGWDeck());

        Combat c = new Combat(h,e);

        for (int i=0;i<100;i++){
            c.enemyTurn();
        }

    }


}
