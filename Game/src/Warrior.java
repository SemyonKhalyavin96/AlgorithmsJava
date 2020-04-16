
public class Warrior extends Hero {
    final  static int MIN_HEALTH = 500;
    final  static int MAX_HEALTH = 1000;
    final  static int MIN_DAMAGE = 50;
    final  static int MAX_DAMAGE = 100;

    public Warrior(String name) {
        super(name);
        this.addHeal = 0;
        this.health = rnd(MIN_HEALTH, MAX_HEALTH);
        this.damage = rnd(MIN_DAMAGE, MAX_DAMAGE);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            System.out.println(this.name + " нападает на " + hero.name);
            hero.causeDamage(damage);
            System.out.println(this.name + " нанес " + damage + " урон(а) " + hero.name);
            System.out.println("Текущее здоровье " + hero.name + " - " + hero.health);

            if(hero.health <= 0){
                System.out.println(this.name + " убил(а) " + hero.name);
                hero.isAlive = false;
            }
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}
