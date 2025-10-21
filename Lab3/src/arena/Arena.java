package arena;

// Arena - зберігає в собі всі основні дані про арену такі як назва та відсоток укриття
public class Arena {
    private String name;
    private double coverChance; // 0.0–1.0, шанс промаху через укриття

    public Arena(String name, double coverChance) {
        this.name = name;
        this.coverChance = coverChance;
    }

    public String getName() {
        return name;
    }

    public double getCoverChance() {
        return coverChance;
    }

    @Override
    public String toString() {
        return name + " (укриття: " + (int)(coverChance * 100) + "%)";
    }
}
