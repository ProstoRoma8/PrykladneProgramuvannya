package main;

import droids.*;
import battle.Battle;
import utils.*;
import arena.*;

import java.util.*;

public class Main {
    private static final List<Droid> droids = new ArrayList<>();
    private static final ArenaData arenaData = new ArenaData();

    private static List<String> lastBattleLog = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                ==== МЕНЮ ====
                1. Створити дроїда
                2. Показати список дроїдів
                3. Бій 1 на 1
                4. Записати бій у файл
                5. Відтворити бій із файлу
                6. Вийти
                """);

            int choice = InputHelper.nextInt("Вибір: ");

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> listDroids();
                case 3 -> startBattle();
                case 4 -> FileManager.saveBattle(lastBattleLog);
                case 5 -> FileManager.loadBattle();
                case 6 -> { System.out.println("До зустрічі!"); return; }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    private static void createDroid() {
        System.out.println("Виберіть тип дроїда: 1-Бойовий, 2-Чаклун, 3-Снайпер");
        int type = InputHelper.nextInt("Тип: ");
        String name = InputHelper.nextLine("Ім'я: ");

        Droid d = switch (type) {
            case 1 -> new BattleDroid(name);
            case 2 -> new WizardDroid(name);
            case 3 -> new SniperDroid(name);
            default -> null;
        };

        if (d != null) {
            droids.add(d);
            System.out.println("Створено: " + d);
        }
    }

    private static void listDroids() {
        if (droids.isEmpty()) System.out.println("Немає створених дроїдів.");
        else {
            for (int i = 0; i < droids.size(); i++) {
                System.out.println((i + 1) + ". " + droids.get(i));
            }
        }
    }

    private static void startBattle() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        // === Вибір арени ===
        System.out.println("Оберіть арену:");
        List<Arena> arenas = arenaData.getArenas();
        for (int i = 0; i < arenas.size(); i++) {
            System.out.println((i + 1) + ". " + arenas.get(i));
        }

        int arenaChoice = InputHelper.nextInt("Вибір арени: ") - 1;
        if (arenaChoice < 0 || arenaChoice >= arenas.size()) {
            System.out.println("Некоректний вибір арени.");
            return;
        }
        Arena arena = arenas.get(arenaChoice);

        // === Вибір дроїдів ===
        listDroids();
        int i1 = InputHelper.nextInt("Оберіть номер першого дроїда (1..n): ") - 1;
        int i2 = InputHelper.nextInt("Оберіть номер другого дроїда: ") - 1;

        if (i1 == i2 || i1 < 0 || i2 < 0 || i1 >= droids.size() || i2 >= droids.size()) {
            System.out.println("Некоректний вибір дроїдів.");
            return;
        }

        Battle battle = new Battle(droids.get(i1), droids.get(i2), arena);
        lastBattleLog = battle.start();
        lastBattleLog.forEach(System.out::println);
    }
}
