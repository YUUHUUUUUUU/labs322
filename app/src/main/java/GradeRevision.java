import java.util.Random;
import java.util.Scanner;

public class GradeRevision extends Event{
    private Hero hero;

    GradeRevision(Hero hero){
        this.hero = hero;
    }

    private void ShowDescription(){
        System.out.println("Your test results just came out, do you wish to review your grade?");
        System.out.println("If you press yes, note that as IFGW is very cruel, thus your life can increase or decrease");
        System.out.println("Your life may change any amount between 0 to 50 points");
        System.out.println("");
        System.out.println("Press 1 to accept and 2 to discard the test review");
    }

    public void begin(){

        ShowDescription();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option==1){
            Random rng = new Random();
            int booleano=rng.nextInt(2);
            Random dano = new Random();
            int dano_total = dano.nextInt(50);

            if (booleano%2==0){
                hero.receiveDirectDamage(dano_total);
            } else {
                hero.receiveDirectDamage(-dano_total);
            }
        }

        if (option==2){
            return;
        }

        else {
            return; //Tratamento de erro aqui!!!
        }
}

}

