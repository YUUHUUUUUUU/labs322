import java.util.Scanner;

public class Shop extends Event{
    private Hero hero;

    Shop(Hero hero){
        this.hero = hero;
    }

    public void begin(){

        System.out.println("You just entered the shop! Choose what you want to buy or press 0 to skip shopping\n" + "You have " + hero.getGold() + " coins");

        if (hero.hasPet()){
            System.out.println("1: Damage Multiplier Buff - Increases the damage multiplier by 0.2" + " Cost: 5");
            System.out.println("2: Damage Multiplier Bigger Buff - Increases the damage multiplier by 0.3" + " Cost: 7");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            if (choice==0){

                return;

            } else if (choice==1){

                hero.addDamageMultiplier(0.2);
                hero.addGold(-5);
                System.out.println("You bought damage multiplier buff!");

            } else if (choice==2){

                hero.addDamageMultiplier(0.3);
                hero.addGold(-7);
                System.out.println("You bought damage multiplier bigger buff!");

            } else {
                return; //implement exception
            }

        } else {
            Pet pet1 = new Pet("Gemini Pro", "Helps you study against IFGW!", 20);
            BuyPetUpgrade buy_pet = new BuyPetUpgrade(10, pet1);
        
            System.out.println("1: "+ buy_pet.describe());
            System.out.println("2: "+ "Damage Multiplier Buff: Increases the damage multiplier by 0.2" + " Cost: 5");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            if (choice==0){

                return;

            } else if (choice==1){

                buy_pet.apply(hero);
                hero.addGold(-buy_pet.getPrice());
                System.out.println("You have a new pet!");

            } else if (choice==2){

                hero.addDamageMultiplier(0.2);
                hero.addGold(-50);
                System.out.println("You bought damage multiplier buff!");

            } else {
                return; //implement exception
            }
        }
    }
}