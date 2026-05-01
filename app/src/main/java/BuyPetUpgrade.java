public class BuyPetUpgrade extends Upgrade{
    Pet pet;
    BuyPetUpgrade(int price, Pet pet){
        super(price, null, null);

        this.pet = pet;
        this.setName(pet.getName());
    }

    @Override
    public void apply(Hero hero) {
        hero.setPet(pet);
    }

    @Override
    public String describe() {
        return pet.describe() + " Cost: " + getPrice() + " gold";
    }
}
