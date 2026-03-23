public abstract class Effect {
    String name;
    String description;
    int duration;
    int intensity;
    Entity target;

    //construct:
    public Effect(String name, String description, int duration, int intensity){
        this.duration=duration;
        this.intensity=intensity;
        this.description=description;
        this.name=name;
    }

    public abstract void use(Entity target);//esse é o notifier


}
