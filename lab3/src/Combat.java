public class Combat{
    Hero hero;
    Enemy enemy; //could be changed to be a list of heroes and enemys in the future

    Combat(Hero hero, Enemy enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    private void heroTurn(){
        hero.getBegginningPublisher().updateAll();

        //implement the hero turn (basically the same as what is in the APP)

        //remember to use effect.isBuff to decide the target
        //buffs are used on themself and debuffs on the opponent
        //notice that many of the functions changed name and/or implementation
        //use the Deck class for the hand, trash and shop

        hero.getEndPublisher().updateAll();
    }

    private void enemyTurn(){
        enemy.getBegginningPublisher().updateAll();

        //implement the enemy turn

        //remember to use effect.isBuff to decide the target
        //buffs are used on themself and debuffs on the opponent,
        //otherwise the enemy turn is basically the same as the hero's,
        //but without the prints we used to interact with the game and,
        //instead we will use a RNG

        enemy.getEndPublisher().updateAll();
    }

    public void combatLoop(){
        heroTurn();
        enemyTurn();
    }
}
