public class BuyPet extends Upgrade{
    Pet pet;
    BuyPet(int price, Pet pet){
        super(price, null, null);

        this.pet = pet;
    }

    @Override
    public void apply(Hero hero) {
        hero.setPet(pet);
    }

    @Override
    public String describe() {
        return pet.describe();
    }
}
