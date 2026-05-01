
public class Hero extends Entity{
    Pet pet = null;

    public Hero(String name, int life, int shield, int energy, int energyRegeneration, double energyMultiplier, Deck deck){
        super(name, life, shield, energy, energyRegeneration, energyMultiplier, deck, 0);
    }

    public Hero(String name, int life, int shield, int energy, int energyRegeneration, double energyMultiplier, Deck deck, int gold){
        super(name, life, shield, energy, energyRegeneration, energyMultiplier, deck, gold);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet(){
        return pet;
    }

    public boolean hasPet(){
        return pet != null;
    }
    public void usePet(Enemy enemy){
        if(hasPet())pet.attack(enemy);
    }

}