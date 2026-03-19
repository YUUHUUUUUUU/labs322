import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;

public class App {

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

        CardShield escudoferro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudomadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudodiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        //
        ArrayList<Card> general = new ArrayList<Card>();
        general.add(espada);
        general.add(tapa);
        general.add(soco);
        general.add(chute);
        general.add(escudoQuebrado);
        general.add(escudodiamante);
        general.add(escudoferro);
        general.add(escudomadeira);

        //escolhendo nome do hero
        System.out.println("Enter your name to start the battle:");
        Scanner entrada = new Scanner(System.in);
        String name = entrada.nextLine();
        hero.setName(name);

        //encontro com o enimigo
        System.out.println("You encountered " + enemy.getName() + "!");
        System.out.println("Press enter to start the duel!");
        System.out.println("You will regenerate " + hero.getRegeneration() + " points of energy each turn!");
        String placeholder = entrada.nextLine();
        if(placeholder == "")//tira o erro por nao usar a variavel
    
        //loob da batalha
        while(true){
            hero.setShield(0);

            //exibindo status do hero e enemy
            hero.showStatus();
            System.out.println("-----------------------");
            enemy.showStatus();
            System.out.println("-----------------------");


            //TURNO DO HERÒI:
            if(general.size()<2){ //se a pilha geral tiver um tamanho insuficiente traz de volta as cartas do lixo
                trashPile.addAll(general);
                general.clear();
                trashPile.shuffle();
                general.addAll(trashPile);
                trashPile.clear();
            }

            System.out.println("Your turn to buy!\nPress the number of the card you want, 3 if you want both or 0 to skip.");

            buyPile.add(general.removeLast());
            buyPile.add(general.removeLast());

            System.out.print("1: ");
            buyPile.get(0).showDescription();
            System.out.print("2: ");
            buyPile.get(1).showDescription();

            int option = entrada.nextInt();
            if(option == 1){
                hand.add(buyPile.get(0));
                trashPile.add(buyPile.get(1))
                buyPile.clear();
            }

            

            while (buyQueue.size()>0 && contador<3){


                System.out.println("If you want to buy " + now.getName() + " press 1. Otherwise, press 0.");
                now.showDescription();


                int option = entrada.nextInt();
                contador++;


                if (option==1 && hero.getEnergy()>=now.getCost()){
                    hand.add(now);
                    System.out.println(now.getName() + " was acquired!");
                    System.out.println("");
                    hero.alteraEnergy(now.getCost());
                    buyQueue.remove();
                    continue;

                } else if (hero.getEnergy()<=now.getCost() && option==1){
                    System.out.println("You don't have enough energy! The card was, therefore, discarded!");
                    System.out.println("");
                    trashQueue.add(now);
                    buyQueue.remove();
                    continue;
                } else if (option==0){
                    trashQueue.add(now);
                    System.out.println("You discarded the " + now.getName() + "!");
                    System.out.println("");
                    buyQueue.remove();
                }
            }

            System.out.println("Press enter to use your cards. If you haven't picked any cards, your turn will be skipped.");
            String novoholder = entrada.nextLine();
            int t=hand.size();
            if (hand.size()>0){
                for (int i=0;i<hand.size();i++){
                    Card now = hand.get(0);
                    now.usar(enemy,hero);
                    hand.remove(now);//descarta depois de usar
                }
            } else if (t==0){
                System.out.println("Turn skipped!");
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

