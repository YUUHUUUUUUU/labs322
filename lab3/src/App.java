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
        Hero hero = new Hero("Nome", 45, 0, 5,3,deck_hero);
        Enemy enemy = new Enemy("IFGW", 20, 0,7,3,deck_enemy);

        //efeitos

        Effect energybuff = new PoisonEffect("Energy Buff", "Increase of energy in the beginning of the next "+energybuff.getDuration()+" rounds", 3, 3);
        Effect poison = new EnergyEffect("Poison", "Reduces life in the end of the next" + poison.getDuration() + " rounds", 2, 4);
        Effect mordida_veneno = new PoisonEffect("Poisoned bite", "Poison present in the creature's teeth",2,3);
        
        //cartas do heroi
        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage chute = new CardDamage("Chute","Energetic attack",4,7);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 5);

        CardShield escudoFerro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudoMadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudoDiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        //cartas do inimigo
        CardDamage garra = new CardDamage("Garra", "Strong attack", 6,8);
        CardDamage mordida_venenosa = new CardDamage("Mordida Venenosa", "Medium attack, but with poison that infects the opponent", 7, 7,mordida_veneno);
        CardShield esquiva = new CardShield("Esquivada sinistra","Dodge the opponent's attack", 2, 2);


        hero.getDeck().getShop().add(espada);
        hero.getDeck().getShop().add(tapa);
        hero.getDeck().getShop().add(tapa);
        hero.getDeck().getShop().add(soco);
        hero.getDeck().getShop().add(chute);
        hero.getDeck().getShop().add(escudoQuebrado);
        hero.getDeck().getShop().add(escudoDiamante);
        hero.getDeck().getShop().add(escudoFerro);
        hero.getDeck().getShop().add(escudoMadeira);
        Collections.shuffle(hero.getDeck().getShop());

        enemy.getDeck().getShop().add(garra);
        enemy.getDeck().getShop().add(mordida_venenosa);
        enemy.getDeck().getShop().add(esquiva);
        Collections.shuffle(enemy.getDeck().getShop());

        //escolhendo nome do hero
        System.out.println("Enter your name to start the battle:");
        Scanner entrada = new Scanner(System.in);
        String name = entrada.nextLine();
        hero.setName(name);

        // espera(500);

        //encontro com o enimigo
        System.out.println("You encountered " + enemy.getName() + "!");
        System.out.println("Press enter to start the duel.");
        String placeholder = entrada.nextLine();
        if(placeholder == "")
    
        //loob da batalha
        while(true){
            hero.setShield(0);

            //exibindo status do hero e enemy
            hero.showStatus();
            System.out.println("-----------------------");
            enemy.showStatus();
            System.out.println("-----------------------");

            //TURNO DO HERÒI:
            if(hero.getDeck().getShop().size()<2){ //se a pilha geral tiver um tamanho insuficiente traz de volta as cartas do lixo
                hero.getDeck().getTrash().addAll(hero.getDeck().getShop());
                hero.getDeck().getShop().clear();
                Collections.shuffle(hero.getDeck().getTrash());
                hero.getDeck().getShop().addAll(hero.getDeck().getTrash());
                hero.getDeck().getTrash().clear();
            }

            System.out.println("Your turn to buy!\nPress the number of the card you want, 3 if you want both or 0 to skip.");
            System.out.println("You have " + hero.getEnergy() + " energy.");
            

            Card card1 = hero.getDeck().getShop().removeLast();
            Card card2 = hero.getDeck().getShop().removeLast();

            System.out.print("1: ");
            card1.showDescription();
            System.out.print("2: ");
            card2.showDescription();

            int option = entrada.nextInt();
            if(option == 1 && hero.getEnergy()>=card1.getCost()){

                if(hero.getDeck().getHand().size()<4){
                    hero.getDeck().getHand().add(card1);
                    hero.getDeck().getTrash().add(card2);
                    System.out.println("You bought " + card1.getName());
                    hero.subtractEnergy(card1.getCost());
                } else System.out.println("Hand full!");

            }else if(option == 2 && hero.getEnergy()>=card2.getCost()){

                if(hero.getDeck().getHand().size()<4){
                    hero.getDeck().getHand().add(card2);
                    hero.getDeck().getTrash().add(card1);
                    hero.subtractEnergy(card2.getCost());
                    System.out.println("You bought " + card2.getName());
                } else System.out.println("Hand full!");

            }else if(option == 3 && hero.getEnergy()>=card2.getCost() && hero.getEnergy()>=card1.getCost()){
                if(hero.getDeck().getHand().size()<3){

                    hero.getDeck().getHand().add(card1);
                    hero.getDeck().getHand().add(card2);
                    System.out.println("You bought " + card1.getName() + " and " + card2.getName());
                    hero.subtractEnergy(card1.getCost()+card2.getCost());

                } else System.out.println("Hand full!");

            }else if (option!=2 && option!=1 && option!=3){

                System.out.println("Shop skipped!");

            } else {
                System.out.println("You don't have enough energy to buy this/these card(s)! Turn skipped.");
            }

            //inplement the peek ability with cost 1 to see what will be the enemy attack

            if(hero.getDeck().getHand().size()==0){
                System.out.println("Your hand is empty, turn skipped");
            }else{
                for(int i=0;i<hero.getDeck().getHand().size();i++){
                    System.out.println("");
                    System.out.println("Current hand:");
                    System.out.print((i+1) + ": ");
                    hero.getDeck().getHand().get(i).showDescription();
                }

                System.err.println("Select the number of the card you want to use or 0 to skip your turn.");
                option = entrada.nextInt();
                if(option>0 && option <= hero.getDeck().getHand().size()){
                    Card selecteCard = hero.getDeck().getHand().get(option-1);
                    selecteCard.use(enemy, hero);
                    hero.getDeck().getHand().remove(selecteCard);
                    
                } else System.out.println("Turn skipped!");
            }

            //ataque do enemy
            if(!enemy.isAlive()){
                System.out.println("You win!");
                //+n points?
                break;
            } else { //TURNO DO INIMIGO FALTA FAZER
                enemy.attack(hero);
                System.out.println(enemy.getName() + " attacked! You lost " + Math.max(1,enemy.getDanopadrao() - hero.getShield()) + " life!");
            }

            //verifica se hero esta vivo
            if(!hero.isAlive()){
                System.out.println("You DIED! hahahaha");
                break;
            }

            //regenera energia do hero e vai para o proximo round
            hero.regenerate();
            System.out.println("Round ended.");
            System.out.println("You regenerated " + hero.getEnergyRegeneration() + " energy!");
            System.out.println("-----------------------------------");
        }

        entrada.close();
    }
}

