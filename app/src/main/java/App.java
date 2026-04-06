import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Na app, usamos basicamente para declararmos os objetos em si: heróis, vilões, feitiços e cartas propriamente ditas.
 */

public class App{

    public static void main(String[] args){
        /** 
        
         * instanciando os decks
         * o que esta sendo passado é um ponteiro pra hand
         * futuras alteracoes no hand, alteram o deck
         * 
         * cada entidade (heroi e vilao) é completamente simétrica: ambas tem decks de mão, de compra e de lixo.
         * Ambas tem escudo, cartas de ataque, efeitos e energia para seus ataques. a diferença é que o vilão faz tudo aleatoriamente.
         */

        ArrayList<Card> hand_hero = new ArrayList<Card>();
        ArrayList<Card> hand_enemy = new ArrayList<Card>();

        Deck deck_hero = new Deck(hand_hero);
        Deck deck_enemy = new Deck(hand_enemy);
        
        //heroi e inimigo
        Hero hero = new Hero("Nome", 25, 0, 5,4, deck_hero);
        Enemy enemy = new Enemy("IFGW", 20, 0,7,3, deck_enemy);

        //efeitos

        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);
        Effect poison = new PoisonEffect("Poison", "Strong Poison", 2, 4);
        Effect mordidaVeneno = new PoisonEffect("Poisoned bite", "Poison present in the creature's teeth",2,3);
        Effect endurecimento_permanente = new PoisonEffect("Permanent rigid skin", "For 5 rounds, the creature maintains a shield of strength 4", 5, 4);

        //cartas do heroi
        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        CardDamage chute = new CardDamage("Chute","Energetic attack",4,7);
        CardDamage cutuvelada = new CardDamage("Cutuvelada","Medium attack", 3, 5);

        CardShield escudoFerro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudoMadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudoDiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        CardEffect poisonCard = new CardEffect("poison", "Strong Poison", 5, poison);
        CardEffect energyRegenCard = new CardEffect("energy buff", "regenerates energy", 4, energyBuff);
        CardEffect shieldIncreaseCard = new CardEffect ("shield buff", "increases shield",5,endurecimento_permanente);

        //cartas do inimigo
        CardDamage garra = new CardDamage("Garra", "Strong attack", 6,8);
        CardDamage mordida_venenosa = new CardDamage("Mordida Venenosa", "Medium attack, but with poison that infects the opponent", 7, 7,mordidaVeneno);
        CardShield endurecer_pele = new CardShield("Pele endurecida","Weak instantaneous defense", 1, 2);
        CardShield esquiva = new CardShield("Esquivada sinistra","Dodge the opponent's attack", 2, 3);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 5);
        CardDamage cuspida = new CardDamage("Cuspida","Really weak Attack", 1, 2);
        CardDamage especial = new CardDamage("Especial", "Costs are low but damage is huge",3,12);


        /** 
         * Aqui, cada deck de compra das entidades é criado e embaralhado.
         */
        hero.getDeck().getShop().add(espada);
        hero.getDeck().getShop().add(chute);
        hero.getDeck().getShop().add(escudoQuebrado);
        hero.getDeck().getShop().add(escudoDiamante);
        hero.getDeck().getShop().add(escudoFerro);
        hero.getDeck().getShop().add(escudoMadeira);
        hero.getDeck().getShop().add(poisonCard);
        hero.getDeck().getShop().add(energyRegenCard);

        hero.getDeck().getShop().add(cutuvelada);

        Collections.shuffle(hero.getDeck().getShop());

        enemy.getDeck().getShop().add(garra);
        enemy.getDeck().getShop().add(garra);
        enemy.getDeck().getShop().add(mordida_venenosa);
        enemy.getDeck().getShop().add(esquiva);
        enemy.getDeck().getShop().add(tapa);
        enemy.getDeck().getShop().add(soco);

        enemy.getDeck().getShop().add(endurecer_pele);
        enemy.getDeck().getShop().add(especial);
        enemy.getDeck().getShop().add(cuspida);
        enemy.getDeck().getShop().add(shieldIncreaseCard);
        Collections.shuffle(enemy.getDeck().getShop());

        //escolhendo nome do hero
        System.out.println("Enter your name to start the battle:");
        Scanner nome = new Scanner(System.in);
        String name = nome.nextLine();
        hero.setName(name);

        // espera(500);

        //encontro com o enimigo
        System.out.println("You encountered " + enemy.getName() + "!");
        System.out.println("Press enter to start the duel.");
        String placeholderr = nome.nextLine();
        if(placeholderr == null); //just so that placeholder is not yellow


        /**
         * Chamamos o combate para iniciarmos os loops de batalha!
         */
        
        Combat combat = new Combat(hero, enemy);
        combat.combatLoop();

        nome.close();
    }
}

