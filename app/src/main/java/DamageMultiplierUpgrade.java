public class DamageMultiplierUpgrade extends Upgrade{
    private double multiplier;

    DamageMultiplierUpgrade(int price, String name, String description, double multiplier){
        super(price,name,description);
        this.multiplier = multiplier;
    }

    @Override
    public void apply(Hero hero) {
        hero.addDamageMultiplier(multiplier);
    }

    @Override
    public String describe() {
        return this.getName() + ": " + this.getDescription() + " (+" + multiplier + " damage multiplier)" + " Cost: " + getPrice() + " gold";
    }
}
