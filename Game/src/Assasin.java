
public class Assasin extends Hero {
    final  static int MIN_HEALTH = 200;
    final  static int MAX_HEALTH = 400;
    final  static int MIN_DAMAGE = 150;
    final  static int MAX_DAMAGE = 300;
    final  static int MIN_CRIT = 50;
    final  static int MAX_CRIT = 100;

    public Assasin(String name) {
        super(name);
        this.addHeal = 0;
        this.health = rnd(MIN_HEALTH, MAX_HEALTH);
        this.damage = rnd(MIN_DAMAGE, MAX_DAMAGE);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            System.out.println(this.name + " нападает на " + hero.name);
            int rand = (int)(Math.random() * 2);
            if(rand == 1){
                hero.causeDamage(damage + rnd(MIN_CRIT, MAX_CRIT));
                System.out.println(this.name + " нанес " + damage + " критического урон(а) " + hero.name);
                System.out.println("Текущее здоровье " + hero.name + " - " + hero.health);
            }
            else{
                hero.causeDamage(damage);
                System.out.println(this.name + " нанес " + damage + " урон(а) " + hero.name);
                System.out.println("Текущее здоровье " + hero.name + " - " + hero.health);
            }

            }
            if(hero.health <= 0){
                System.out.println(this.name + " убил(а) " + hero.name);
                hero.isAlive = false;
            }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
