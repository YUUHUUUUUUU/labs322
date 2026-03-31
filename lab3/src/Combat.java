import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Combat{
    Hero hero;
    Enemy enemy; //could be changed to be a list of heroes and enemys in the future
        
    Combat(Hero hero, Enemy enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    private void heroTurn(){
        Scanner entrada = new Scanner(System.in);

        //faz tudo com os efeitos iniciais
        hero.getBegginningPublisher().updateAll();

        if(!hero.isAlive())return;

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
            } else{
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getHand().add(card2);
                System.out.println("Hand full!");
            } 
        }else if(option == 2 && hero.getEnergy()>=card2.getCost()){
            if(hero.getDeck().getHand().size()<4){
                hero.getDeck().getHand().add(card2);
                hero.getDeck().getTrash().add(card1);
                hero.subtractEnergy(card2.getCost());
                System.out.println("You bought " + card2.getName());
            } else{
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getHand().add(card2);
                System.out.println("Hand full!");
            } 
        }else if(option == 3 && hero.getEnergy()>=card2.getCost() + card1.getCost()){
            if(hero.getDeck().getHand().size()<3){
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getHand().add(card2);
                System.out.println("You bought " + card1.getName() + " and " + card2.getName());
                hero.subtractEnergy(card1.getCost()+card2.getCost());
            } else{
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getHand().add(card2);
                System.out.println("Hand full!");
            } 
        }else if (option!=2 && option!=1 && option!=3){
            hero.getDeck().getTrash().add(card1);
            hero.getDeck().getTrash().add(card2);
            System.out.println("Shop skipped!");
        } else {
            hero.getDeck().getTrash().add(card1);
            hero.getDeck().getTrash().add(card2);
            System.out.println("You don't have enough energy to buy this/these card(s)! Turn skipped.");
        }

        if(hero.getDeck().getHand().size()==0){
            System.out.println("Your hand is empty, turn skipped");
        }else{
            for(int i=0;i<hero.getDeck().getHand().size();i++){
                System.out.println("");
                System.out.println("Current hand:");
                System.out.print((i+1) + ": ");
                hero.getDeck().getHand().get(i).showDescription();
            }

            System.out.println("Select the number of the card you want to use or 0 to skip your turn.");
            option = entrada.nextInt();
            if(option>0 && option <= hero.getDeck().getHand().size()){
                Card selecteCard = hero.getDeck().getHand().get(option-1);
                selecteCard.use(hero, enemy);
                hero.getDeck().getHand().remove(selecteCard);
                
            } else System.out.println("Turn skipped!");
        }

        //implement the hero turn (basically the same as what is in the APP)

        //remember to use effect.isBuff to decide the target
        //buffs are used on themself and debuffs on the opponent
        //notice that many of the functions changed name and/or implementation
        //use the Deck class for the hand, trash and shop

        hero.getEndPublisher().updateAll();
    }

    private void enemyTurn(){
        enemy.getBegginningPublisher().updateAll();

        if(!enemy.isAlive())return;

        if(enemy.getDeck().getShop().size()<2){ //se a pilha geral tiver um tamanho insuficiente traz de volta as cartas do lixo
            enemy.getDeck().getShop().addAll(enemy.getDeck().getTrash());
            enemy.getDeck().getTrash().clear();

            Collections.shuffle(enemy.getDeck().getShop());
        }
        
        Card card1 = enemy.getDeck().getShop().removeLast();
        Card card2 = enemy.getDeck().getShop().removeLast();

        //card1.showDescription();
        //card2.showDescription();

        Random rng = new Random();
        int option=rng.nextInt(5);

        if(option == 1 && enemy.getEnergy()>=card1.getCost()){
            if(enemy.getDeck().getHand().size()<4){
                enemy.getDeck().getHand().add(card1);
                enemy.getDeck().getTrash().add(card2);
                System.out.println(enemy.getName() + " bought " + card1.getName());
                enemy.subtractEnergy(card1.getCost());
            } else{
                enemy.getDeck().getTrash().add(card1);
                enemy.getDeck().getTrash().add(card2);
                System.out.println("Hand full!");
            } 
        }else if(option == 2 && enemy.getEnergy()>=card2.getCost()){
            if(enemy.getDeck().getHand().size()<4){
                enemy.getDeck().getHand().add(card2);
                enemy.getDeck().getTrash().add(card1);
                enemy.subtractEnergy(card2.getCost());
                System.out.println(enemy.getName() + " bought " + card2.getName());
            }else{
                enemy.getDeck().getTrash().add(card1);
                enemy.getDeck().getTrash().add(card2);
                System.out.println("Hand full!");
            }
        }else if(option == 3 && enemy.getEnergy()>=card2.getCost()+card1.getCost()){
            if(enemy.getDeck().getHand().size()<3){
                enemy.getDeck().getHand().add(card1);
                enemy.getDeck().getHand().add(card2);
                System.out.println(enemy.getName() + " bought " + card1.getName() + " and " + card2.getName());
                enemy.subtractEnergy(card1.getCost()+card2.getCost());
            }else{
                enemy.getDeck().getTrash().add(card1);
                enemy.getDeck().getTrash().add(card2);
                System.out.println("Hand full!");
            } 
        }else if (option!=2 && option!=1 && option!=3){
            System.out.println("Shop skipped by "+ enemy.getName() + "!");
            enemy.getDeck().getTrash().add(card1);
            enemy.getDeck().getTrash().add(card2);
        } else {
            System.out.println(enemy.getName() + " shop skipped!");
            enemy.getDeck().getTrash().add(card1);
            enemy.getDeck().getTrash().add(card2);
        }

        if(enemy.getDeck().getHand().size()==0){
            System.out.println("Hand empty, turn skipped");
        }else{
            // for(int i=0;i<enemy.getDeck().getHand().size();i++){
            //     System.out.println("");
            //     System.out.println("Current hand:");
            //     System.out.print((i+1) + ": ");
            //     enemy.getDeck().getHand().get(i).showDescription();
            // }

            //System.out.println("Select the number of the card you want to use or 0 to skip your turn."); //keep for debug
            option = rng.nextInt(enemy.getDeck().getHand().size()+1);
            if(option>0 && option <= enemy.getDeck().getHand().size()){
                Card selecteCard = enemy.getDeck().getHand().get(option-1);
                selecteCard.use(enemy, hero);
                enemy.getDeck().getHand().remove(selecteCard);
                
            } else System.out.println("Turn skipped!");
        }

        enemy.getEndPublisher().updateAll();
    }

    public void combatLoop(){
        while (true){
            heroTurn();
            if(!hero.isAlive()){
                System.out.println("You died!");
                return;
            }
            if(!enemy.isAlive()){
                System.out.println("You win!");
                break;
            }
            
            enemyTurn();
            if(!hero.isAlive()){
                System.out.println("You died!");
                return;
            }
            if(!enemy.isAlive()){
                System.out.println("You win!");
                break;
            }

            hero.regenerate();
            enemy.regenerate();
        }
    }
}
