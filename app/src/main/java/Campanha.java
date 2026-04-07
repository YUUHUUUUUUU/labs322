import java.util.ArrayList;
import java.util.Scanner;

public class Campanha {
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy boss;
    private Deck deck_default;

    Campanha (){
        Effect mordidaVeneno = new PoisonEffect("Poisoned bite", "Poison present in the creature's teeth",2,3);
        Effect endurecimento_permanente = new PoisonEffect("Permanent rigid skin", "For 5 rounds, the creature maintains a shield of strength 4", 5, 4);
    
        //cartas do inimigo
        CardDamage garra = new CardDamage("Garra", "Strong attack", 6,8);
        CardShield endurecer_pele = new CardShield("Pele endurecida","Weak instantaneous defense", 1, 2);
        CardShield esquiva = new CardShield("Esquivada sinistra","Dodge the opponent's attack", 2, 3);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 5);
        CardDamage cuspida = new CardDamage("Cuspida","Really weak Attack", 1, 2);
        CardDamage especial = new CardDamage("Especial", "Costs are low but damage is huge",3,12);
        CardEffect shieldIncreaseCard = new CardEffect ("shield buff", "increases shield",5,endurecimento_permanente);
        CardDamage mordida_venenosa = new CardDamage("Mordida Venenosa", "Medium attack, but with poison that infects the opponent", 7, 7,mordidaVeneno);
    
        ArrayList<Card> hand_enemy = new ArrayList<Card>();
        
        hand_enemy.add(garra);
        
        hand_enemy.add(garra);
        hand_enemy.add(mordida_venenosa);
        hand_enemy.add(esquiva);
        hand_enemy.add(tapa);
        hand_enemy.add(soco);
        
        hand_enemy.add(endurecer_pele);
        hand_enemy.add(especial);
        hand_enemy.add(cuspida);
        hand_enemy.add(shieldIncreaseCard);
        
        deck_default = new Deck(hand_enemy);
    
    }

    //talvez seja this.deck_default
    private void criaCampanha(){
        Enemy enemy1 = new Enemy("IFGW", 12, 0,5,3, deck_default);
        Enemy enemy2 = new Enemy("IA",16,0,7,3, deck_default);
        Enemy enemy3 = new Enemy("IE",20,0,7,4, deck_default);
        Enemy enemy4 = new Enemy("IEL",24,0,7,5, deck_default);
        Enemy boss = new Enemy();
    }

    public void campanha_loop(Hero hero){

        criaCampanha();

        ArrayList<Enemy> options = new ArrayList<Enemy>();
        options.add(enemy1);
        int s=options.size();

        while (hero.isAlive() && boss.isAlive()){

            System.out.println("Select the corresponding number to choose your opponent!");


            for (int i=0;i<s;i++){
                System.out.println((i+1) + ": " + options.get(i).getName());
            }

            Scanner entrada = new Scanner(System.in);
            int choice = entrada.nextInt();

            Enemy atual = options.get(choice-1);

            Combat combat = new Combat(hero, atual);
            combat.combatLoop();

        }

        if (hero.isAlive()){
            System.out.println("You finished the campaign! Congrats :)");
        } else {
            System.out.println("Restart the game!");
        }
    }



    


    
}
