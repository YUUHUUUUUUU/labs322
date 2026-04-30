public abstract class Upgrade {
    private int price;
    private String name;
    private String description;

    Upgrade(int price, String name, String description){
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public abstract void apply(Hero hero);

    public abstract String describe();

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
