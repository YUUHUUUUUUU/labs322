
public class EnergyEffect extends Effect {
        EnergyEffect(String name, String description, int duration, int intensity){
        super(name, description, duration, intensity, true, true);
    }

    @Override
    public void use(Entity target) {
        System.err.println(target.getName() + " received " + this.getIntensity() + " energy from potion");
        target.subtractEnergy(-this.getIntensity());
        this.reduceDuration();
    }

    @Override
    public Effect copy() {
        return new EnergyEffect(this.getName(), this.getDescription(), this.getDuration(), this.getIntensity());
    }

    @Override
    public String useDescription() {
        return "+" + this.getIntensity() + " energy at the start of the next " + this.getDuration() + " rounds";
    }
}
