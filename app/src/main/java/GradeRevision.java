import java.util.Random;
import java.util.Scanner;

public class GradeRevision extends Event{
    private Hero hero;

    GradeRevision(Hero hero){
        this.hero = hero;
    }

    private void ShowDescription(){
        System.out.println("Your test results just came out, do you wish to review your grade?");
        System.out.println("Note that as IFGW is very cruel, your life can increase or decrease");
        System.out.println("Your life may change any amount between 25 and 50 points");
        System.out.println("Press 1 to accept and 2 to decline the test review");
    }

    public void begin(){

        ShowDescription();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option==1){
            Random rng = new Random();
            int booleano=rng.nextInt(2);
            Random dano = new Random();
            int dano_total = dano.nextInt(25)+26;

            if (booleano%2==0){
                hero.receiveDirectDamage(dano_total);
                System.out.println("You received "+dano_total+ " damage! :(");
            } else {
                hero.receiveDirectDamage(-dano_total);
                System.out.println("You received "+dano_total+ " life! :)");
            }
        }else if (option==2){
            System.out.println("Invalid input, revision skipped!");
            return;
        }
        else {
            System.out.println("Invalid input, revision skipped!");
        }
        return;
    }

}

