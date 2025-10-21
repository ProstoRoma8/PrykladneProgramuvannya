package droids;

/** WizardDroid - дроїд чаклун, кожен другий пропускається через лікування */
public class WizardDroid extends Droid {
    private int turnCounter = 0; // лічильник ходів

    public WizardDroid(String name) {
        super(name, 90, 20);
    }

    @Override
    public int attack() {
        turnCounter++;

        if (turnCounter % 2 == 0) {
            int heal = 15; // скільки HP відновлює
            health += heal;
            if (health > 90) health = 90; // максимум початкове здоров'я
            System.out.println(name + " відновлює " + heal + " HP!");
            return 0; // цього ходу не атакує
        }

        return damage;
    }

    @Override
    public String toString() {
        return "Чаклун " + super.toString();
    }
}
