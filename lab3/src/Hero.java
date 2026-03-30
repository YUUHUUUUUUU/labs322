public class Hero extends Entity{

    //Now that the enemy also uses cards, enemy and hero are completely symetric and the subclasses are no longer needed
    //But we opted to keep them in case they are needed in the future

    //This game is working more as a PVP where our entities and the opponent's are totally symmetric
    //What we can do to make the heroes and monsters more different is changing their stats and decks to fit the characters

    public Hero(String name, int life, int shield, int energy, int energyRegeneration, Deck deck){
        super(name, life, shield, energy, energyRegeneration, deck);
    }

}