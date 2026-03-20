public class Enemy extends Entity{
    private int dano_padrao;

    public Enemy(String name, int life, int shield, int dano_padrao){

        super(name,life,shield);

        this.dano_padrao=dano_padrao;
    }

    //toma dano do herói de acordo com o parâmetro da arma do herói
    public void receiveDamage(int damage){
        this.subtractLife(damage);
    }

    public int getDano(Hero hero){
        return Math.max(this.dano_padrao-hero.getShield(),1);
    }

    public int getDanopadrao(){
        return this.dano_padrao;
    }

    //mostra o status do inimigo (se em algum momento o inimigo tiver energia esse pode virar um metodo da classe Entity)
    public void showStatus(){
        System.out.println(this.getName() + " status:");
        System.out.println("Life: " + this.getLife());
    }

    public void attack(Entity hero){
        hero.receiveDamage(dano_padrao);
        System.out.println("");
    }
}
