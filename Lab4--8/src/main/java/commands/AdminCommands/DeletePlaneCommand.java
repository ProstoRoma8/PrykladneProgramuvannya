package commands.AdminCommands;
import commands.Command;

public class DeletePlaneCommand implements Command {
    @Override
    public void execute() {
        System.out.println("поки нічого");
    }

    @Override
    public String getName() {
        return "Видалити літак";
    }
}
