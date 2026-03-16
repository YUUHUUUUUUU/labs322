import java.util.Scanner;

public class App {

    public static void main(String[] args){
        //instanciando objetos do jogo
        Heroi heroi = new Heroi("Nome", 35, 0, 5,3);
        Inimigo inimigo = new Inimigo("IFGW", 20, 0,7);
        CartaDano espada = new CartaDano("Espada", 5, 10);
        CartaDano tapa = new CartaDano("Tapa", 2, 3);
        CartaEscudo escudo = new CartaEscudo("Escudo", 4, 6);
        CartaEscudo escudoQuebrado = new CartaEscudo("Escudo Quebradao", 2, 2);

        
        //escolhendo nome do heroi
        System.out.println("Enter your name to begin battle:");
        Scanner entrada = new Scanner(System.in);
        String name = entrada.nextLine();
        heroi.setName(name);

        //encontro com o enimigo
        System.out.println("You encountered " + inimigo.getName() + "!");
        System.out.println("Press enter to start the duel!");
        System.out.println("You will regenerate " + heroi.getRegeneracao() + " points of energy each turn!");
        String placeholder = entrada.nextLine();
    
        //loob da batalha
        while(true){
            heroi.setShield(0);

            //exibindo status do heroi e inimigo
            heroi.showStatus();
            System.out.println("-----------------------");
            inimigo.showStatus();
            System.out.println("-----------------------");

            System.out.println("Select a number to choose your action (an invalid entry will skip your turn)");

            //opcoes de acao
            System.out.print("1: ");
            espada.showStatus();
            System.out.print("2: ");
            tapa.showStatus();
            System.out.print("3: ");
            escudo.showStatus();
            System.out.print("4: ");
            escudoQuebrado.showStatus();

            //loop de escolha de acao do heroi
            while(true){
                int action = entrada.nextInt();
                if(action == 1){
                    //usa espada
                    if(heroi.getEnergia()>=espada.getCusto()){
                        espada.usar(inimigo,heroi);
                        break;

                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 2){
                    //usa tapa
                    if(heroi.getEnergia()>=tapa.getCusto()){
                        tapa.usar(inimigo,heroi);
                        break;

                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 3){
                    //usa escudo
                    if(heroi.getEnergia()>=escudo.getCusto()){
                        escudo.usar(heroi);
                        break;
                    }else{
                        System.out.print("Insuficient energy, choose another action!\n");
                    }
                }else if(action == 4){
                    //usa escudoQuebrado
                    if(heroi.getEnergia()>=escudoQuebrado.getCusto()){
                        escudoQuebrado.usar(heroi);
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

            //ataque do inimigo
            if(!inimigo.estaVivo()){
                System.out.println("You win!");
                //+n points?
                break;
            } else {
                inimigo.atacar(heroi);
                System.out.println("");
                System.out.println(inimigo.getName() + " attacked! " + "You lost " + inimigo.getDano(heroi) + " life!");
                System.out.println("");
            }

            //verifica se heroi esta vivo
            if(!heroi.estaVivo()){
                System.out.println("You DIED! hahahaha");
                break;
            }

            //regenera vida do heroi e vai para o proximo round
            heroi.regenera();
            System.out.println("Round ended.");
            System.out.println("You regenerated " + heroi.getRegeneracao() + " energy!");
            System.out.println("-----------------------------------");
        }

        entrada.close();
    }
}

