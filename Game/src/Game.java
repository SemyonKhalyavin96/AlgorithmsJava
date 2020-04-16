import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Game {
    public static void main(String[] args) {

        int round = 0;

        Hero[] team1 = new Hero[]{new Warrior("Bristleback")
                , new Assasin("Phantom assasin")
                , new Doctor("Dazzle")};


        Hero[] team2 = new Hero[]{new Warrior("Spirit breaker")
                , new Assasin("Riki")
                , new Doctor("Chen")};

        System.out.println("---НАЧАЛО БИТВЫ---");
        for (Hero t1: team1) {
            t1.info();
        }

        System.out.println("-----------------");

        for (Hero t2: team2) {
            t2.info();
        }
        System.out.println("-----------------");
        ArrayList<Hero> avaliableTeam1 = new ArrayList<>();
        ArrayList<Hero> avaliableTeam2 = new ArrayList<>();
        for(Hero h : team1){
            if(h.isAlive) avaliableTeam1.add(h);
        }
        for(Hero h : team2){
            if(h.isAlive) avaliableTeam2.add(h);
        }

        while(isEndGame(team1, team2)){
            for(Hero h : team1){
                if(h.isAlive) avaliableTeam1.add(h);
            }
            for(Hero h : team2){
                if(h.isAlive) avaliableTeam2.add(h);
            }
            int rndHero = 0;
            int rndTeam = 0;
            int rnd = 0;
            System.out.println("___Раунд " + round + "___");
            rndTeam = (int)(Math.random() * 2);
            if(rndTeam == 0){ // ход команды 1
               int cnt = 0;
               while(cnt < 3){
                   rndHero = (int)(Math.random()* avaliableTeam1.size());
                   if(avaliableTeam1.get(rndHero) instanceof Doctor){
                       rnd = (int)(Math.random()* avaliableTeam1.size());
                       avaliableTeam1.get(rndHero).healing(avaliableTeam1.get(rnd));
                       cnt++;
                   }
                   else{
                       rnd = (int)(Math.random()* avaliableTeam2.size());
                       avaliableTeam1.get(rndHero).hit(avaliableTeam2.get(rnd));
                       cnt++;
                   }
               }
            }
            else{
                int cnt = 0;
                while(cnt < 3){
                    rndHero = (int)(Math.random()* avaliableTeam2.size());
                    if(avaliableTeam2.get(rndHero) instanceof Doctor){
                        rnd = (int)(Math.random()* avaliableTeam2.size());
                        avaliableTeam2.get(rndHero).healing(avaliableTeam2.get(rnd));
                        cnt++;
                    }
                    else{
                        rnd = (int)(Math.random()* avaliableTeam1.size());
                        avaliableTeam2.get(rndHero).hit(avaliableTeam1.get(rnd));
                        cnt++;
                    }
                }
            }
            avaliableTeam1.clear();
            avaliableTeam2.clear();
            round++;
        }

        if(isTeamAlive(team2) && !(isOnlyDoctors(team1,team2))){
            System.out.println("Команда 2 победила!!!");
        }

        else if(isTeamAlive(team1) && !(isOnlyDoctors(team1,team2))){
            System.out.println("Команда 1 победила!!!");
        }

        else if(isOnlyDoctors(team1,team2)){
            System.out.println("Ничья!!!");
        }

        System.out.println("-----------------");
        for (Hero t1: team1) {
            t1.info();
        }

        System.out.println("-----------------");

        for (Hero t2: team2) {
            t2.info();
        }


    }

    static boolean isEndGame(Hero[] team1, Hero[] team2){
        boolean team1Alive = isTeamAlive(team1);
        boolean team2Alive = isTeamAlive(team2);
        return team1Alive && team2Alive || isOnlyDoctors(team1, team2);
    }

    static boolean isTeamAlive(Hero[] team){
        boolean isAlive = false;
        for(Hero h : team){
            isAlive |= h.isAlive;
        }
        return isAlive;
    }

    static boolean isOnlyDoctors(Hero[] team1, Hero[] team2){
        boolean drLive = false;
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.addAll(Arrays.asList(team1));
        heroes.addAll(Arrays.asList(team2));
        boolean drAlive = false;
        for(Hero h : heroes){
            if(!(h instanceof Doctor) && h.isAlive){
                return false;
            }
            else if(h instanceof Doctor){
                drLive |= h.isAlive;
            }
        }
        return drLive;
    }


}
