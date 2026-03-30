import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class App {

    // public void espera(int n){//implementando esperas curtas para nao ter jumpscare de muito texto de uma vez
    //     try {
    //         Thread.sleep(n);
    //     } catch (InterruptedException e){}
    // }

    public static void main(String[] args) throws InterruptedException{
        //instanciando os decks
        ArrayList<Card> hand = new ArrayList<Card>();
        ArrayList<Card> buyPile = new ArrayList<Card>();
        ArrayList<Card> trashPile = new ArrayList<Card>();
        
        //todos os objetos
        Hero hero = new Hero("Nome", 45, 0, 5,3);
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
        System.out.println("Enter your name:");
        Scanner entrada = new Scanner(System.in);
        String name = entrada.nextLine();
        hero.setName(name);
        System.out.println();

        Thread.sleep(1500);

        //encontro com o enimigo
        System.out.println("You encountered " + enemy.getName() + "!");
        System.out.println("Press enter to start the battle");
        String placeholder = entrada.nextLine();
        if(placeholder == "")
        System.out.println();
    
        //loob da batalha
        while(true){
            hero.setShield(0);

            //exibindo status do hero e enemy
            System.out.println("----------------------------------------------");
            hero.showStatus();
            System.out.println("----------------------------------------------");
            enemy.showStatus();
            System.out.println("----------------------------------------------\n");

            Thread.sleep(2100);

            //TURNO DO HERÒI:
            if(buyPile.size()<2){ //se a pilha geral tiver um tamanho insuficiente traz de volta as cartas do lixo
                trashPile.addAll(buyPile);
                buyPile.clear();
                Collections.shuffle(trashPile);
                buyPile.addAll(trashPile);
                trashPile.clear();
            }
            //compra
            System.out.println("Your turn to buy!\nPress the number of the card you want, 3 if you want both or 0 to skip.");
            System.out.println("You have " + hero.getEnergy() + " energy.");            

            //prepara as cartas disponiveis
            Card card1 = buyPile.removeLast();
            Card card2 = buyPile.removeLast();

            //exibe as cartas disponiveis
            System.out.print("1: ");
            card1.showDescription();
            System.out.print("2: ");
            card2.showDescription();

            //logica da compra
            int option = entrada.nextInt();
            if(option == 1 && hero.getEnergy()>=card1.getCost()){
                if(hand.size()<4){
                    hand.add(card1);
                    trashPile.add(card2);
                    System.out.println("You bought " + card1.getName() + "\n");
                    hero.alteraEnergy(card1.getCost());
                } else System.out.println("Hand full!\n");
            }else if(option == 2 && hero.getEnergy()>=card2.getCost()){
                if(hand.size()<4){
                    hand.add(card2);
                    trashPile.add(card1);
                    hero.alteraEnergy(card2.getCost());
                    System.out.println("You bought " + card2.getName() + "\n");
                } else System.out.println("Hand full!\n");
            }else if(option == 3 && hero.getEnergy()>=card2.getCost() && hero.getEnergy()>=card1.getCost()){
                if(hand.size()<3){
                    hand.add(card1);
                    hand.add(card2);
                    System.out.println("You bought " + card1.getName() + " and " + card2.getName() + "\n");
                    hero.alteraEnergy(card1.getCost()+card2.getCost());
                } else System.out.println("Hand full!\n");
            }else if(option!=2 && option!=1 && option!=3){
                System.out.println("Shop skipped!\n");
            } else{
                System.out.println("Not enough energy! Turn skipped.\n");
            }

            Thread.sleep(1500);

            //uso das cartas na mao
            if(hand.size()==0){
                System.out.println("Your hand is empty, turn skipped\n");
            }else{
                System.out.println("Current hand:");
                for(int i=0;i<hand.size();i++){
                    System.out.print((i+1) + ": ");
                    hand.get(i).showDescription();
                }
                System.out.println();

                System.err.println("Select the number of the card you want to use or 0 to skip your turn.");
                option = entrada.nextInt();
                if(option>0 && option <= hand.size()){
                    Card selecteCard = hand.get(option-1);
                    selecteCard.usar(enemy, hero);
                    hand.remove(selecteCard);
                } else System.out.println("Turn skipped!\n");
            }

            Thread.sleep(2100);

            //ataque do enemy
            if(!enemy.isAlive()){
                System.out.println("You win!\n");
                //+n points?
                break;
            }else{
                enemy.attack(hero);
                System.out.println(enemy.getName() + " attacked! You lost " + Math.max(1,enemy.getDanopadrao() - hero.getShield()) + " life!\n");
            }

            //verifica se hero esta vivo
            if(!hero.isAlive()){
                System.out.println("You DIED! hahahaha\n");
                break;
            }

            Thread.sleep(2100);

            //regenera energia do hero e vai para o proximo round
            hero.regenera();
            System.out.println("Round ended.");
            System.out.println("You regenerated " + hero.getRegeneration() + " energy!\n");

            Thread.sleep(1500);
        }

        entrada.close();
    }
}

