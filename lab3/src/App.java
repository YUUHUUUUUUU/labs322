import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class App{

    public static void main(String[] args){
        //instanciando os decks

        //o que esta sendo passado é um ponteiro pra hand
        //futuras alteracoes no hand, alteram o deck
        ArrayList<Card> hand_hero = new ArrayList<Card>();
        ArrayList<Card> hand_enemy = new ArrayList<Card>();

        Deck deck_hero = new Deck(hand_hero);
        Deck deck_enemy = new Deck(hand_enemy);
        
        //heroi e inimigo
        Hero hero = new Hero("Nome", 45, 0, 5,3, deck_hero);
        Enemy enemy = new Enemy("IFGW", 20, 0,7,3, deck_enemy);

        //efeitos

        Effect energyBuff  = new EnergyEffect("Energy Buff", "Regenerates Energy", 3, 3);
        Effect poison = new PoisonEffect("Poison", "Strong Poison", 2, 4);
        Effect mordidaVeneno = new PoisonEffect("Poisoned bite", "Poison present in the creature's teeth",2,3);
        
        //cartas do heroi
        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        CardDamage chute = new CardDamage("Chute","Energetic attack",4,7);

        CardShield escudoFerro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudoMadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudoDiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        CardEffect poisonCard = new CardEffect("poison", "Strong Poison", 5, poison);
        CardEffect energyRegenCard = new CardEffect("energy buff", "regenerates energy", 4, energyBuff);

        //cartas do inimigo
        CardDamage garra = new CardDamage("Garra", "Strong attack", 6,8);
        CardDamage mordida_venenosa = new CardDamage("Mordida Venenosa", "Medium attack, but with poison that infects the opponent", 7, 7,mordidaVeneno);
        CardShield esquiva = new CardShield("Esquivada sinistra","Dodge the opponent's attack", 2, 2);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 5);


        hero.getDeck().getShop().add(espada);
        hero.getDeck().getShop().add(chute);
        hero.getDeck().getShop().add(escudoQuebrado);
        hero.getDeck().getShop().add(escudoDiamante);
        hero.getDeck().getShop().add(escudoFerro);
        hero.getDeck().getShop().add(escudoMadeira);
        hero.getDeck().getShop().add(poisonCard);
        hero.getDeck().getShop().add(energyRegenCard);

        Collections.shuffle(hero.getDeck().getShop());

        enemy.getDeck().getShop().add(garra);
        enemy.getDeck().getShop().add(mordida_venenosa);
        enemy.getDeck().getShop().add(esquiva);
        enemy.getDeck().getShop().add(tapa);
        enemy.getDeck().getShop().add(soco);
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

        Combat combat = new Combat(hero, enemy);
        combat.combatLoop();
        
        nome.close();
    }
}

