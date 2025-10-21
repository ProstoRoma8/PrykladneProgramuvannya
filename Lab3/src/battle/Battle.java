package battle;

import droids.Droid;
import arena.Arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    private final Droid d1;
    private final Droid d2;
    private final Arena arena;
    private final Random rnd = new Random();
    private final List<String> log = new ArrayList<>();

    public Battle(Droid d1, Droid d2, Arena arena) {
        this.d1 = d1;
        this.d2 = d2;
        this.arena = arena;
    }

    public List<String> start() {
        log.add("БІЙ НА АРЕНІ: " + arena);
        log.add("Між " + d1.getName() + " та " + d2.getName());
        log.add("---------------------------");

        while (d1.isAlive() && d2.isAlive()) {
            log.add(attackWithCover(d1, d2));
            if (d2.isAlive()) {
                log.add(attackWithCover(d2, d1));
            }
        }

        String winner = d1.isAlive() ? d1.getName() : d2.getName();
        log.add("Переміг " + winner + "!");
        return log;
    }

    private String attackWithCover(Droid attacker, Droid defender) {
        if (attacker instanceof droids.WizardDroid) {
            int damage = attacker.attack();
            if (damage == 0) {
                return attacker.getName() + " зцілює себе і пропускає хід!";
            }
            defender.takeDamage(damage);
            return attacker.getName() + " завдає " + damage + " шкоди " + defender.getName();
        }

        boolean ignoreCover = attacker instanceof droids.SniperDroid sniper && sniper.ignoresCover();
        int chance = rnd.nextInt(100);

        if (!ignoreCover && chance < arena.getCoverChance() * 100) {
            return attacker.getName() + " промахнувся — " + defender.getName() + " сховався!";
        } else {
            int damage = attacker.attack();
            defender.takeDamage(damage);
            return attacker.getName() + " завдає " + damage + " шкоди " + defender.getName();
        }
    }

}
