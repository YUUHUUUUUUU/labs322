import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

/**
 * Controla o fluxo e as regras da batalha no jogo.
 * Gerencia a alternância de turnos, o sistema de compras de cartas,
 * o uso de energia e a vida das entidades.
 */
public class Combat{
    Hero hero;
    Enemy enemy; //could be changed to be a list of heroes and enemies in the future
        
    /**
     * Construtor da classe de combate.
     * @param hero A entidade herói controlada pelo jogador.
     * @param enemy A entidade inimiga controlada pelo sistema.
     */
    Combat(Hero hero, Enemy enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    /**
     * Executa a lógica do turno do jogador (Herói).
     * Aplica efeitos iniciais, exibe o status de combate, gerencia a compra 
     * de cartas da loja e permite a seleção e uso de cartas da mão.
     */
    private void heroTurn(){
        Scanner scanner = new Scanner(System.in);

        // Faz o update dos efeitos que devem ser aplicados no início do turno
        hero.getBeginningPublisher().updateAll();

        if(!hero.isAlive()){
            return;
        }

        hero.setShield(0);

        // Exibe status do hero e enemy
        hero.showStatus();
        System.out.println("-----------------------");
        enemy.showStatus();
        System.out.println("-----------------------");

        // Compra de cartas
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

        int option = scanner.nextInt();
        if(option == 1 && hero.getEnergy()>=card1.getCost()){
            if(hero.getDeck().getHand().size()<4){
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getTrash().add(card2);
                System.out.println("You bought " + card1.getName());
                hero.subtractEnergy(card1.getCost());
            } else{
                hero.getDeck().getTrash().add(card1);
                hero.getDeck().getTrash().add(card2);
                System.out.println("Hand full!");
            } 
        }else if(option == 2 && hero.getEnergy()>=card2.getCost()){
            if(hero.getDeck().getHand().size()<4){
                hero.getDeck().getHand().add(card2);
                hero.getDeck().getTrash().add(card1);
                hero.subtractEnergy(card2.getCost());
                System.out.println("You bought " + card2.getName());
            } else{
                hero.getDeck().getTrash().add(card1);
                hero.getDeck().getTrash().add(card2);
                System.out.println("Hand full!");
            } 
        }else if(option == 3 && hero.getEnergy()>=card2.getCost() + card1.getCost()){
            if(hero.getDeck().getHand().size()<3){
                hero.getDeck().getHand().add(card1);
                hero.getDeck().getHand().add(card2);
                System.out.println("You bought " + card1.getName() + " and " + card2.getName());
                hero.subtractEnergy(card1.getCost()+card2.getCost());
            } else{
                hero.getDeck().getTrash().add(card1);
                hero.getDeck().getTrash().add(card2);
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

        // Uso das cartas em mãos
        if(hero.getDeck().getHand().size()==0){
            System.out.println("Your hand is empty, turn skipped");
        }else{
            System.out.println("Current hand:");
            for(int i=0;i<hero.getDeck().getHand().size();i++){
                System.out.println("");
                System.out.print((i+1) + ": ");
                hero.getDeck().getHand().get(i).showDescription();
            }
            System.out.println("Select the number of the card you want to use or 0 to skip your turn.");
            option = scanner.nextInt();
            if(option>0 && option <= hero.getDeck().getHand().size()){
                Card selectedCard = hero.getDeck().getHand().get(option-1);
                selectedCard.use(hero, enemy);
                hero.getDeck().getHand().remove(selectedCard);
                hero.getDeck().getTrash().add(selectedCard);
                
            } else System.out.println("Turn skipped!");
        }

        hero.getEndPublisher().updateAll();
    }

    /**
     * Executa a lógica automática do turno do inimigo.
     * Utiliza geração de números aleatórios (RNG) para simular a tomada 
     * de decisão de compras e uso de cartas.
     */
    private void enemyTurn(){
        enemy.getBeginningPublisher().updateAll();

        if(!enemy.isAlive())return;

        // Se a loja tiver menos de 2 cartas, recicla o lixo
        if(enemy.getDeck().getShop().size()<2){
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

        // Compra de cartas
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

        // Uso das cartas em mãos
        if(enemy.getDeck().getHand().size()==0){
            System.out.println(enemy.getName() + " hand is empty, turn skipped");
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
                Card selectedCard = enemy.getDeck().getHand().get(option-1);
                selectedCard.use(enemy, hero);
                enemy.getDeck().getHand().remove(selectedCard);
                enemy.getDeck().getTrash().add(selectedCard);
                
            } else System.out.println("Turn skipped!");
        }

        enemy.getEndPublisher().updateAll();
    }

    /**
     * Loop da batalha, que continua até que o inimigo ou herói morra
     */
    public void combatLoop(){
        while (true){
            heroTurn();

            if(!enemy.isAlive()){
                System.out.println("You win!");
                return;
            }else if(!hero.isAlive()){
                System.out.println("You died!");
                return;
            }

            enemyTurn();

            if(!enemy.isAlive()){
                System.out.println("You win!");
                return;
            }else if(!hero.isAlive()){
                System.out.println("You died!");
                return;
            }

            hero.regenerate();
            enemy.regenerate();
        }
    }
}
