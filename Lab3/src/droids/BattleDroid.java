package droids;

/** BattlerDroid -  простий бойовий дроїд із додатковим заистом від атак */
public class BattleDroid extends Droid {
    private final double damageReduction; // від 0.05 до 0.10

    public BattleDroid(String name) {
        super(name, 120, 25);
        this.damageReduction = 0.05 + Math.random() * 0.05;
    }

    @Override
    public void takeDamage(int dmg) {
        int reduced = (int) Math.round(dmg * (1 - damageReduction));
        super.takeDamage(reduced);
    }

    @Override
    public String toString() {
        return name + " [Бойовий | HP=" + health + ", DMG=" + damage +
                ", зменшення шкоди=" + Math.round(damageReduction * 100) + "%]";
    }
}
