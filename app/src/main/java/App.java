import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Classe principal responsável pela inicialização do jogo, configuração 
 * inicial das entidades (Herói e Inimigo) e execução do loop de combate.
 *
 * @author Rafael Ruas - 204824
 * @author João Gilberti - 288885
 */
public class App{

    public static void main(String[] args){
        System.out.println("Welcome to the game! Choose one option to start.");
        System.out.println("1: New Game");
        System.out.println("2: Load File");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1){
            /** 
            
            * instanciando os decks
            * o que esta sendo passado é um ponteiro pra hand
            * futuras alteracoes no hand, alteram o deck
            * 
            * cada entidade (heroi e vilao) é completamente simétrica: ambas tem decks de mão, de compra e de lixo.
            * Ambas tem escudo, cartas de ataque, efeitos e energia para seus ataques. a diferença é que o vilão faz tudo aleatoriamente.
            */
            
            //heroi
            Hero hero = new Hero("Nome", 100, 0, 5,4, 1, new StandardHeroDeck());

            //escolhendo nome do hero
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            hero.setName(name);

            //cheat
            System.out.println("Use cheats? [y/n]");
            String sChoice = scanner.nextLine();
            if(sChoice.equals("y")){
                System.out.println("Imput the cheat code:");
                sChoice = scanner.nextLine();
                if(sChoice.equals("42")){
                    System.out.println("Cheat Activated! Life set to 1000000, Energy Regeneration to 100 and Damage Multiplier to 10");
                    hero.setLife(1000000);
                    hero.setEnergyRegeneration(100);
                    hero.setDamageMultiplier(10);
                }else{
                    System.out.println("Invalid cheat code!");
                }
            }
            

            //comeca a campanha
            Campaign campanha = new Campaign();
            campanha.campanha_loop(hero);
        }else if(choice == 2){
            //implement save with json
        }else{
            //implement exception handling
        }

        scanner.close();
    }
}

