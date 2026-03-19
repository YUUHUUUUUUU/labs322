import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class App {

    // public void espera(int n){//implementando esperas curtas para nao ter jumpscare de muito texto de uma vez
    //     try {
    //         Thread.sleep(n);
    //     } catch (InterruptedException e){}
    // }

    public static void main(String[] args){
        //instanciando os decks
        ArrayList<Card> hand = new ArrayList<Card>();
        ArrayList<Card> buyPile = new ArrayList<Card>();
        ArrayList<Card> trashPile = new ArrayList<Card>();
        
        //todos os objetos
        Hero hero = new Hero("Nome", 45, 0, 5,3,hand);
        Enemy enemy = new Enemy("IFGW", 20, 0,7);

        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage chute = new CardDamage("Chute","Energetic attack",4,7);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 5);

        CardShield escudoFerro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudoMadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudoDiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        buyPile.add(espada);
        buyPile.add(tapa);
        buyPile.add(soco);
        buyPile.add(chute);
        buyPile.add(escudoQuebrado);
        buyPile.add(escudoDiamante);
        buyPile.add(escudoFerro);
        buyPile.add(escudoMadeira);
        Collections.shuffle(buyPile);

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
            if(buyPile.size()<2){ //se a pilha geral tiver um tamanho insuficiente traz de volta as cartas do lixo
                trashPile.addAll(buyPile);
                buyPile.clear();
                Collections.shuffle(trashPile);
                buyPile.addAll(trashPile);
                trashPile.clear();
            }

            System.out.println("Your turn to buy!\nPress the number of the card you want, 3 if you want both or 0 to skip.");

            Card card1 = buyPile.removeLast();
            Card card2 = buyPile.removeLast();

            System.out.print("1: ");
            card1.showDescription();
            System.out.print("2: ");
            card2.showDescription();

            int option = entrada.nextInt();
            if(option == 1){
                if(hand.size()<4){
                    hand.add(card1);
                    trashPile.add(card2);
                    System.out.println("You bought " + card1.getName());
                } else System.out.println("Hand full!");
            }else if(option == 2){
                if(hand.size()<4){
                    hand.add(card2);
                    trashPile.add(card1);
                    System.out.println("You bought " + card1.getName());
                } else System.out.println("Hand full!");
            }else if(option == 3){
                if(hand.size()<3){
                    hand.add(card1);
                    hand.add(card2);
                    System.out.println("You bought " + card1.getName() + "and " + card2.getName());
                } else System.out.println("Hand full!");
            }else System.out.println("Shop skipped!");

            //inplement the peek ability with cost 1 to see what will be the enemy attack

            if(hand.size()==0){
                System.out.println("Your hand is empty, turn skipped");
            }else{
                for(int i=0;i<hand.size();i++){
                    System.out.println("Current hand:");
                    System.out.print((i+1) + ": ");
                    hand.get(i).showDescription();
                }

                System.err.println("Select the number of the card you want to use or 0 to skip your turn.");
                option = entrada.nextInt();
                if(option>0 && option <= hand.size()){
                    Card selecteCard = hand.get(option-1);
                    if(hero.getEnergy()>=selecteCard.getCost()){
                        selecteCard.usar(enemy, hero);
                        hand.remove(selecteCard);
                    }else{
                        System.out.println("Not enough energy, turn skipped!");
                    }
                    
                }else System.out.println("Turn skipped!");
            }

            //ataque do enemy
            if(!enemy.isAlive()){
                System.out.println("You win!");
                //+n points?
                break;
            } else {
                enemy.attack(hero);
            }

            //verifica se hero esta vivo
            if(!hero.isAlive()){
                System.out.println("You DIED! hahahaha");
                break;
            }

            //regenera energia do hero e vai para o proximo round
            hero.regenera();
            System.out.println("Round ended.");
            System.out.println("You regenerated " + hero.getRegeneration() + " energy!");
            System.out.println("-----------------------------------");
        }

        entrada.close();
    }
}

