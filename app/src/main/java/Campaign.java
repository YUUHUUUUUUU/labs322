import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Campaign {
    private Enemy IFGW_Undergraduate = new Enemy("IFGW Undergraduate", 100, 0, 0, 3, 1, new StandardIFGWDeck());
    private Enemy IFGW_PAD = new Enemy("IFGW PAD", 120, 0, 0, 4, 1.2, new StandardIFGWDeck());
    private Enemy IFGW_Master = new Enemy("IFGW Master", 120, 0, 0, 5, 1.5, new StandardIFGWDeck());
    private Enemy IFGW_PHD = new Enemy("IFGW PHD", 300, 0, 0, 2, 1, new StandardIFGWDeck());
    private Enemy IFGW_Full_Professor = new Enemy("IFGW Full Professor", 300, 0, 0, 5, 2, new StandardIFGWDeck());

    private ArrayList<Enemy> enemies = new ArrayList<>(List.of(IFGW_Undergraduate, IFGW_PAD, IFGW_Master, IFGW_PHD, IFGW_Full_Professor));
    private List<List<Integer>> adjacencyList = List.of(
        List.of(1),
        List.of(2, 3),
        List.of(4),
        List.of(4),
        List.of()
    );

    Campaign (){
        CardFactory factory = new CardFactory();
        IFGW_Full_Professor.getDeck().getShop().add(factory.getCard("Atomic Blast")); //We can add special cards that are not in the standard Deck here
    }

    public void campanha_loop(Hero hero){
        List<Integer> currentOptions = List.of(0);
        Integer currentIndex;
        Enemy currentEnemy;
        Scanner entrada = new Scanner(System.in);
        int choice;

        while(true){

            System.out.println("Select the corresponding number to choose your opponent!");

            for (int i=0;i<currentOptions.size();i++){
                System.out.println((i+1) + ": " + enemies.get(currentOptions.get(i)).getName()); //Implement enemy.showStats so that the user can make a concious decision, maybe also include a description
            }

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            
            currentIndex = currentOptions.get(choice - 1);
            currentEnemy = enemies.get(currentIndex); //TODO: handle exception

            Combat combat = new Combat(hero, currentEnemy);
            combat.combatLoop();

            if(hero.isAlive()){
                if(currentEnemy == IFGW_Full_Professor){
                    System.out.println("You finished this campaign, congratulations!");
                    return;
                }

                hero.regenerate();
                System.out.println("You regenerated 100 Life!\n" +
                                    "Choose what to do next:\n" +
                                    "1: Go to the next Combat\n" +
                                    "2: Save and exit");
                hero.receiveDirectDamage(-100);

                choice = scanner.nextInt();
                if(choice == 1){
                    currentOptions = adjacencyList.get(currentIndex);
                }else if(choice ==2){
                    //implement save
                }else{
                    //implement exception handling
                }

            }
        }
    }



    


    
}
