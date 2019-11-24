package by.htp.jd2.maksimkosmachev.test.command;

import java.util.HashMap;
import java.util.Map;

final public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION,new RegistrationCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }
}
