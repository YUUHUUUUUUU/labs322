public class Enemy extends Entity {
    private String name;
    private int life;
    private int shield;
    private int dano_padrao;

    //construct
    public Enemy(String name, int life, int shield, int dano_padrao){

        super(name,life,shield);

        this.name=name;
        this.life=life;
        this.shield=shield;
        this.dano_padrao=dano_padrao;
    }

    //toma dano do herói de acordo com o parâmetro da arma do herói
    public void receiveDamage(int damage){
        this.life-=damage;
    }

    // public void alteraEnergia(int custo){
    //     this.energia-=custo;
    // }

    public int getDano(Hero hero){
        return Math.max(this.dano_padrao-hero.getShield(),1);
    }

    //mostra o status do inimigo
    public void showStatus(){
        System.out.println(this.name + " status:");
        System.out.println("Life: " + this.life);
    }

    public void attack(Entity hero){
        hero.receiveDamage(dano_padrao);
        System.out.println(this.name + " attacked! " + "You lost " + dano_padrao + " life!");
        System.out.println("");
    }

}
