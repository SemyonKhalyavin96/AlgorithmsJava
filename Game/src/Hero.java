abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;
    protected boolean isAlive;

    public Hero(String name) {
        this.name = name;
        this.isAlive = true;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if (isAlive) {
            health -= damage;
        }
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAddHeal() {
        return addHeal;
    }

    void addHealth(int health) {
        this.health += health;
    }

    boolean canAttack(){
        return !(this instanceof Doctor) && this.isAlive;
    }

    boolean canHeal(){
        return this instanceof Doctor && this.isAlive;
    }

    void info() {

        System.out.println(name + ": " + "здоровье " +(isAlive ? health : 0) + ", урон " + damage);
    }
}

