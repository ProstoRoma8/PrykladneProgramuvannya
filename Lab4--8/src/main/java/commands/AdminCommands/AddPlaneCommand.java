package commands.AdminCommands;

import commands.Command;
import main.AppContext;
import models.*;

import java.util.Scanner;

public class AddPlaneCommand implements Command {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("=== ДОДАВАННЯ НОВОГО ЛІТАКА ===");
        System.out.println("Оберіть тип літака:");
        System.out.println("1 - Пасажирський");
        System.out.println("2 - Вантажний");

        int type = getValidInt("Ваш вибір: ", 1, 2);

        System.out.print("Введіть модель літака: ");
        String model = sc.nextLine();

        // Перевірки: число має бути > 0
        int fuel = getValidInt("Витрати пального (кг/год): ", 1, 50000);
        int range = getValidInt("Дальність польоту (км): ", 100, 20000);
        double speed = getValidDouble("Крейсерська швидкість (км/год): ", 100, 3000);

        Plane plane = null;

        if (type == 1) {
            // Для пасажирського питаємо про кількість людей
            int seats = getValidInt("Місткість (кількість пасажирів): ", 1, 853);

            // Зручне питання про бізнес-клас (так/ні)
            boolean hasBusiness = askYesNo("Чи є бізнес-клас? (y/n): ");

            int businessSeats = 0;
            if (hasBusiness) {
                businessSeats = getValidInt("Кількість місць бізнес-класу: ", 1, seats);
            }

            // capacity передаємо як double, бо так у батьківському класі
            plane = new PassengerPlane(
                    model, fuel, range, speed, (double) seats,
                    hasBusiness, businessSeats
            );

        } else {
            // Для вантажного питаємо про тонни
            double tons = getValidDouble("Вантажопідйомність (тонн): ", 0.1, 500);

            plane = new CargoPlane(
                    model, fuel, range, speed, tons
            );
        }

        AppContext.logger.info("Додано новий літак: " + model + " (Тип: " + type + ")");
        AppContext.airline.addPlane(plane);
        System.out.println("✅ Літак '" + model + "' успішно додано до флоту!");
    }

    @Override
    public String getName() {
        return "Додати літак";
    }

    // --- Допоміжні методи (щоб код був чистим) ---

    // Метод для безпечного зчитування цілого числа в межах min-max
    private int getValidInt(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine(); // очистка буфера
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("⚠️ Число має бути в діапазоні від " + min + " до " + max);
                }
            } else {
                System.out.println("⚠️ Будь ласка, введіть коректне ціле число.");
                sc.next(); // пропуск некоректного вводу
            }
        }
    }

    // Метод для безпечного зчитування дробового числа
    private double getValidDouble(String prompt, double min, double max) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                sc.nextLine(); // очистка буфера
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("⚠️ Число має бути в діапазоні від " + min + " до " + max);
                }
            } else {
                System.out.println("⚠️ Будь ласка, введіть коректне число (наприклад, 850,5).");
                sc.next();
            }
        }
    }

    // Метод для питання Так/Ні
    private boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String str = sc.nextLine().trim().toLowerCase();
            if (str.equals("y") || str.equals("yes") || str.equals("так") || str.equals("+")) {
                return true;
            } else if (str.equals("n") || str.equals("no") || str.equals("ні") || str.equals("-")) {
                return false;
            }
            System.out.println("⚠️ Введіть 'y' (так) або 'n' (ні).");
        }
    }
}