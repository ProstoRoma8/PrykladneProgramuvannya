package commands.AdminCommands;
import commands.Command;

public class SortPlanesCommand implements Command {
    @Override
    public void execute() {
        System.out.println("поки нічого");
    }

    @Override
    public String getName() {
        return "Сортувати літаки";
    }
}
