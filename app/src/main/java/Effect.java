/**
 * Representa a classe base para todos os efeitos (buffs ou debuffs) aplicáveis a entidades.
 * Define atributos como duração, intensidade e tempo de ativação.
 * Utiliza o padrão Publisher/Subscriber para se definir o timing do efeito no ciclo de combate.
 */
public abstract class Effect{
    private String name;
    private String description;
    private int duration;
    private int intensity; //the meaning varies depending on the specific effect
    private boolean timingIsEnd; //true if the effect is activated at the end of the round
    private boolean isBuff; //true if the effect is a buff and false if it is a debuff

    /**
     * Construtor base para inicializar os parâmetros do efeito.
     * @param name O nome do efeito.
     * @param description A descrição narrativa do efeito.
     * @param duration Quantos turnos o efeito dura.
     * @param intensity A intensidade do efeito, significado varia dependendo do efeito.
     * @param timingIsEnd Indica se o processamento ocorre no final (true) ou início (false) do turno.
     * @param isBuff Indica se é um efeito um buff (true) ou debuff (false).
     */
    public Effect(String name, String description, int duration, int intensity, boolean timingIsEnd, boolean isBuff){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.intensity = intensity;
        this.timingIsEnd = timingIsEnd; //this atribute should be determined by the type of effect in the 'super'
        this.isBuff = isBuff; //idem
    }

    /**
     * Cria e retorna uma cópia exata do efeito.
     * Necessário para instanciar novos efeitos de forma independente durante a batalha.
     * @return Uma nova instância idêntica deste efeito.
     */
    public abstract Effect copy();

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

    /**
     * Inscreve este efeito no Publisher correto da entidade alvo,
     * baseando-se no atributo timingIsEnd para decidir o momento de ativação.
     * @param target A entidade que receberá o efeito.
     */
    public void subscribe(Entity target){//identify the publisher that the effect should subscribe to and does so
        if(this.timingIsEnd) target.getEndPublisher().subscribe(this);
        else target.getBeginningPublisher().subscribe(this);
    }

    public void reduceDuration(){
        this.duration--;
    }

    /**
     * Método chamado pelo publisher para aplicar o efeito em cada rodada.
     * As subclasses devem implementar o que o efeito faz.
     * @param target A entidade alvo do efeito neste turno.
     */
    public abstract void use(Entity target);

    public abstract String useDescription();

}