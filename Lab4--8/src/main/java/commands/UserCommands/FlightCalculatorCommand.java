package commands.UserCommands;

import commands.Command;
import main.AppContext;
import models.*;

import java.util.Scanner;

public class FlightCalculatorCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        AppContext.airline.printFleetShort();

        System.out.print("Оберіть літак (індекс): ");
        if (!sc.hasNextInt()) {
            System.out.println("Потрібно ввести число!");
            AppContext.logger.warning("Калькулятор: користувач ввів некоректний індекс (не число).");
            return;
        }
        int index = sc.nextInt();

        Plane plane = AppContext.airline.getPlaneByIndex(index);

        if (plane == null) {
            System.out.println("Невірний вибір.");
            AppContext.logger.warning("Калькулятор: спроба доступу до неіснуючого літака (індекс " + index + ").");
            return;
        }

        System.out.print("Відстань польоту (км): ");
        int distance = sc.nextInt();

        double hours = (double) distance / plane.getCruiseSpeedKmh();
        double fuelNeeded = hours * plane.getFuelConsumption();

        System.out.printf("Час польоту: %.1f год.\n", hours);
        System.out.printf("Необхідне пальне: %.2f кг\n", fuelNeeded);
        AppContext.logger.info("Виконано розрахунок польоту для " + plane.getModel() + ". Дистанція: " + distance + " км.");

        if (distance > plane.getFlightRangeKm()) {
            System.out.println("\n!!! УВАГА: перевищено максимальну дальність (" + plane.getFlightRangeKm() + " км) !!!");
            AppContext.logger.warning("Розрахунок: перевищено дальність для " + plane.getModel());
        }

        System.out.print("Деталі літака: ");
        if (plane instanceof PassengerPlane) {
            System.out.println("Тип: Пасажирський");
        } else if (plane instanceof CargoPlane) {
            System.out.println("Тип: Вантажний");
        } else {
            System.out.println("Тип: Загальний");
        }
    }

    @Override
    public String getName() {
        return "Калькулятор польотів";
    }
}