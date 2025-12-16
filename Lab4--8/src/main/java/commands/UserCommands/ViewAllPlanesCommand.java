package commands.UserCommands;
import commands.Command;

public class ViewAllPlanesCommand implements Command {
    @Override
    public void execute() {
        System.out.println("поки нічого");
    }

    @Override
    public String getName() {
        return "Перегляд усіх літаків";
    }
}
