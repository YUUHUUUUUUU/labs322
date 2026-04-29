public class DamageMultiplierUpgrade extends Upgrade{
    private int multiplier;

    DamageMultiplierUpgrade(int price, String name, String description, int multiplier){
        super(price,name,description);
        this.multiplier = multiplier;
    }

    @Override
    public void apply(Hero hero) {
        hero.addDamageMultiplier(multiplier);
    }

    @Override
    public String describe() {
        return this.getName() + ": " + this.getDescription() + " (+" + multiplier + "damage multiplier)";
    }
}
