public class Doctor extends Hero {
    final private static int MIN_HEALTH = 300;
    final private static int MAX_HEALTH = 600;
    final private static int MIN_HEAL = 10;
    final private static int MAX_HEAL = 30;

    public Doctor(String name) {
        super(name);
        this.health = rnd(MIN_HEALTH, MAX_HEALTH);
        this.addHeal = rnd(MIN_HEAL, MAX_HEAL);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        if(hero instanceof Warrior && hero.health > Warrior.MAX_HEALTH){
            hero.health = Warrior.MAX_HEALTH;
        }
        else if(hero instanceof Assasin && hero.health > Assasin.MAX_HEALTH){
            hero.health = Assasin.MAX_HEALTH;
        }
        else if(hero instanceof Doctor && hero.health > Doctor.MAX_HEALTH){
            hero.health = Doctor.MAX_HEALTH;
        }
        System.out.println(this.name + " восстановил " + hero.name + " " + this.addHeal + " единиц здоровья.");
        System.out.println("Текущее здоровье " + hero.name + " - " + hero.health);
    }
}