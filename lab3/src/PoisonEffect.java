public class PoisonEffect extends Effect{
    
    PoisonEffect(String name, String description, int duration, int intensity){
        super(name, description, duration, intensity, false, false);
    }

    @Override
    public void use(Entity target) {
        System.err.println(target.getName() + "received " + this.getIntensity() + " damage from poison");
        target.receiveDirectDamage(this.getIntensity()); //not affected by shield
        this.reduceDuration();
    }

    @Override
    public Effect copy() {
        return new PoisonEffect(this.getName(), this.getDescription(), this.getDuration(), this.getIntensity());
    }

    @Override
    public String useDescription() {
        return (-1 * this.getIntensity()) + " life at the start of the next " + this.getDuration() + " rounds";
    }
}