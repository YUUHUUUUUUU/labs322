public abstract class Effect{
    private String name;
    private String description;
    private int duration;
    private int intensity; //the meaning varies depending on the specific effect
    private boolean timingIsEnd; //true if the effect is activated at the beggining of the round
    private boolean isBuff; //true if the effect is a buff and false if it is a debuff

    public Effect(String name, String description, int duration, int intensity, boolean timingIsEnd, boolean isBuff){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.intensity = intensity;
        this.timingIsEnd = timingIsEnd; //this atribute should be determined by the type of effect
        this.isBuff = isBuff;
    }

    public abstract Effect copy();

    //getters
    public String getDescription() {
        return description;
    }
    public int getDuration() {
        return duration;
    }
    public String getName() {
        return name;
    }
    public int getIntensity() {
        return intensity;
    }
    public boolean getIsBuff(){
        return isBuff;
    }

    public void subscribe(Entity target){//identify the publisher that the effect should subscribe to and does so
        if(this.timingIsEnd) target.getEndPublisher().subscribe(this);
        else target.getBegginningPublisher().subscribe(this);
    }

    public void reduceDuration(){
        this.duration--;
    }

    public abstract void use(Entity target); //this is the method called when the effect should activate

    public abstract String useDescription();

}
