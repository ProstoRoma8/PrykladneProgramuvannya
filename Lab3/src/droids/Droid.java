package droids;

/** Droid - батьківсткий клас для всіх дроїдів який тримає в собі всі основні дані про дроїда ОЗ, Шкода, Ім'я */
public class Droid {
    protected int health;
    protected int damage;
    protected String name;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) health = 0;
    }

    public int attack() {
        return damage;
    }

    @Override
    public String toString() {
        return name + " [HP=" + health + ", DMG=" + damage + "]";
    }
}
