import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;

public class App {

    public static void main(String[] args){
        //instanciando os decks
        ArrayList<Card> hand = new ArrayList<Card>();
        Stack<Card> buyStack = new Stack<Card>();
        Stack<Card> trashStack = new Stack<Card>();
        
        //todos os objetos
        Hero hero = new Hero("Nome", 35, 0, 5,3,hand);
        Enemy enemy = new Enemy("IFGW", 20, 0,7);

        CardDamage espada = new CardDamage("Espada","Strong attack", 5, 10);
        CardDamage tapa = new CardDamage("Tapa","Weak attack",2, 3);
        CardDamage chute = new CardDamage("Chute","Energetic attack",4,7);
        CardDamage soco = new CardDamage("Soco", "Medium attack", 3, 6);

        CardShield escudoferro = new CardShield("Escudo","Strong defense", 4, 7);
        CardShield escudoQuebrado = new CardShield("Escudo Quebradao","Weak defense", 2, 2);
        CardShield escudomadeira = new CardShield("Escudo de madeira","Medium defense",3,5);
        CardShield escudodiamante = new CardShield("Escudo de diamante","Expensive and resistent",10, 18);

        //
        Stack<Card> general = new Stack<Card>();
        general.push(espada);
        general.push(tapa);
        general.push(soco);
        general.push(chute);
        general.push(escudoQuebrado);
        general.push(escudodiamante);
        general.push(escudoferro);
        general.push(escudoQuebrado);

        //escolhendo nome do hero
        System.out.println("Enter your name to begin battle:");
        Scanner entrada = new Scanner(System.in);
        String name = entrada.nextLine();
        hero.setName(name);

        //encontro com o enimigo
        System.out.println("You encountered " + enemy.getName() + "!");
        System.out.println("Press enter to start the duel!");
        System.out.println("You will regenerate " + hero.getRegeneration() + " points of energy each turn!");
        String placeholder = entrada.nextLine();
    
        //loob da batalha
        while(true){
            hero.setShield(0);

            //exibindo status do hero e enemy
            hero.showStatus();
            System.out.println("-----------------------");
            enemy.showStatus();
            System.out.println("-----------------------");


            //TURNO DO HERÒI:
            Collections.shuffle(general);

            int i=0;
            while(i<=2){

                buyStack.push(general.peek());
                //tira do cmc e poe no fim
                Card aux = general.peek();
                general.pop();
                general.push(aux);
                i++;
            }

            System.out.println("You have " + hero.getEnergy() + " energy.");
            System.out.println("If you want to buy " + buyStack.peek().getName() + " press 1. Otherwise, press 0.");







             
            
            
            
            
            
            
            
            System.out.println("Select a number to choose your action (an invalid entry will skip your turn)");

            //opcoes de acao
            System.out.print("1: ");
            espada.showDescription();
            System.out.print("2: ");
            tapa.showDescription();
            System.out.print("3: ");
            escudoferro.showDescription();
            System.out.print("4: ");
            escudoQuebrado.showDescription();

            //loop de escolha de acao do hero
            while(true){
                int action = entrada.nextInt();
                if(action == 1){
                    //usa espada
                    if(hero.getEnergy()>=espada.getCost()){
                        espada.usar(enemy,hero);
                        break;

                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 2){
                    //usa tapa
                    if(hero.getEnergy()>=tapa.getCost()){
                        tapa.usar(enemy,hero);
                        break;

                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 3){
                    //usa escudo
                    if(hero.getEnergy()>=escudoferro.getCusto()){
                        escudoferro.usar(enemy,hero);
                        break;
                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 4){
                    //usa escudoQuebrado
                    if(hero.getEnergy()>=escudoQuebrado.getCusto()){
                        escudoQuebrado.usar(enemy,hero);
                        break;

                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else{
                    //pula turno
                    System.out.print("Invalid entry, turn skipped!\n");
                    break;
                }
            }

            //ataque do enemy
            if(!enemy.isAlive()){
                System.out.println("You win!");
                //+n points?
                break;
            } else {
                enemy.attack(hero);
                System.out.println("");
                System.out.println(enemy.getName() + " attacked! " + "You lost " + enemy.getDano(hero) + " life!");
                System.out.println("");
            }

            //verifica se hero esta vivo
            if(!hero.isAlive()){
                System.out.println("You DIED! hahahaha");
                break;
            }

            //regenera vida do hero e vai para o proximo round
            hero.regenera();
            System.out.println("Round ended.");
            System.out.println("You regenerated " + hero.getRegeneration() + " energy!");
            System.out.println("-----------------------------------");
        }

        entrada.close();
    }
}

