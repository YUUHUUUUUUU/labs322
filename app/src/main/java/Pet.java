public class Pet {
    String name;
    String description;
    int damage;

    Pet(String name, String description, int damage){
        this.description = description;
        this.damage = damage;
        this.name = name;
    }

    public void attack(Enemy enemy){
        System.out.println(name + " Attacked!");
        System.out.println(enemy.getName() + " lost " + Math.max(damage-enemy.getShield(),1) + " life!\n");
        enemy.receiveDamage(damage);
    }

    public String describe(){
        return name + ": " + description + " (inflicts " + damage + " damage to the enemy each round after the hero's attack!)";
    }

    public String getName() {
        return name;
    }
}
