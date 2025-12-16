package commands.AdminCommands;
import commands.Command;

public class EditPlaneCommand implements Command {
    @Override
    public void execute() {
        System.out.println("поки нічого");
    }

    @Override
    public String getName() {
        return "Редагувати літак";
    }
}
