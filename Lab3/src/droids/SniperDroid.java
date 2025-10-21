package droids;

/** SniperDroid - дроїд снайпер, його бойова особливість ігнорувати укриття які є на різних картах */
public class SniperDroid extends Droid {
    private final double ignoreCoverChance;

    public SniperDroid(String name) {
        super(name, 80, 35);
        this.ignoreCoverChance = 0.05 + Math.random() * 0.05; // 5–10%
    }

    public boolean ignoresCover() {
        return Math.random() < ignoreCoverChance;
    }

    @Override
    public String toString() {
        return name + " [Снайпер | HP=" + health + ", DMG=" + damage +
                ", шанс ігнорувати укриття=" + Math.round(ignoreCoverChance * 100) + "%]";
    }
}
