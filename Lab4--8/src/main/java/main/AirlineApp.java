package main;

import commands.*;
import commands.AdminCommands.*;
import commands.UserCommands.*;
import java.util.logging.Level;
import java.util.Scanner;

public class AirlineApp {
    public static void main(String[] args) {
        AppContext.logger.info("=== Запуск додатка AirlineApp ===");

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Вітаємо в системі авіакомпанії!");
            System.out.print("Увійдіть як (1 - Адміністратор, 2 - Користувач): ");
            int roleInput = scanner.nextInt();

            UserRole role = (roleInput == 1) ? UserRole.ADMIN : UserRole.USER;
            Menu menu = new Menu();

            AppContext.logger.info("Авторизація: обрано роль " + role);

            // Спільні команди
            menu.addCommand(1, new ViewAllPlanesCommand());
            menu.addCommand(2, new FlightCalculatorCommand());
            menu.addCommand(3, new SettingsCommand());

            // Додаткові команди для адміністратора
            if (role == UserRole.ADMIN) {
                menu.addCommand(4, new AddPlaneCommand());
                menu.addCommand(5, new EditPlaneCommand());
                menu.addCommand(6, new DeletePlaneCommand());
                menu.addCommand(7, new SortPlanesCommand());
            }

            menu.addCommand(0, new ExitCommand());
            menu.handleUserInput();
            AppContext.logger.info("Роботу програми завершено коректно.");
        } catch (Exception e) {
            AppContext.logger.log(Level.SEVERE, "Критичний збій програми!", e);
            System.out.println("\n❌ Сталася критична помилка. Деталі збережено у файлі app.log");
        }
    }
}
