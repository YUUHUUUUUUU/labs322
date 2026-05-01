import java.util.Scanner;
import java.util.ArrayList;

public class Shop extends Event{
    private Hero hero;
    private ArrayList<Upgrade> upgrades = new ArrayList<>();

    Shop(Hero hero){
        this.hero = hero;

        upgrades.add(new DamageMultiplierUpgrade(10, "Individual Study", "Study to be more effective against IFGW", 0.2));
        upgrades.add(new DamageMultiplierUpgrade(13, "Guided Study", "Study with a monitor to improve tour skills", 0.3));
        if(!hero.hasPet())upgrades.add(new BuyPetUpgrade(20,new Pet("Gemini Pro", "Will help you in your battles", 10)));
    }

    public void begin(){

        System.out.println("You just entered the shop! Choose what you want to buy or press 0 to skip shopping\n" + "You have " + hero.getGold() + " coins");

        for(int i=0;i<upgrades.size();i++){
            System.out.println("");
            System.out.print((i+1) + ": " + upgrades.get(i).describe());
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice <0 || choice >upgrades.size()){
            System.out.println("Invalid entry, shop skipped");
            return;
        }else if(choice == 0){
            System.out.println("Shop skipped");
            return;
        }else{
            Upgrade upgrade = upgrades.get(choice-1);
            if(upgrade.getPrice()>hero.getGold()){
                System.out.println("Not enough gold! Shop skipped.");
            }else{
                upgrade.apply(hero);
                System.out.println("You bought " + upgrade.getName());
                hero.addGold(-upgrade.getPrice());
            }
        }
    }
}