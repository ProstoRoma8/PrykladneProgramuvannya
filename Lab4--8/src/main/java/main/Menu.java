package main;

import commands.Command;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, Command> commands = new LinkedHashMap<>();

    public void addCommand(int number, Command command) {
        commands.put(number, command);
    }

    public void display() {
        System.out.println("\n=== ГОЛОВНЕ МЕНЮ ===");
        for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            display();
            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }
}
