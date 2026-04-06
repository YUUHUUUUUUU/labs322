public class ShieldEffect extends Effect {
    ShieldEffect(String name, String description, int duration, int intensity){
        super(name, description, duration, intensity, false, true);
    }

    @Override
    public void use(Entity target) {
        System.err.println(target.getName() + " activated a shield of strength" + this.getIntensity());
        target.increaseShield(getIntensity());
        this.reduceDuration();
    }

    @Override
    public Effect copy() {
        return new ShieldEffect(this.getName(), this.getDescription(), this.getDuration(), this.getIntensity());
    }

    @Override
    public String useDescription() {
        return "+" + this.getIntensity() + " shield at the beginning of the next " + this.getDuration() + " rounds";
    }
}
