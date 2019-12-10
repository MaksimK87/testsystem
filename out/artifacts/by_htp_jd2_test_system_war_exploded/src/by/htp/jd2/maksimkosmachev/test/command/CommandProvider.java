package by.htp.jd2.maksimkosmachev.test.command;

import by.htp.jd2.maksimkosmachev.test.command.impl.AuthorizationCommand;
import by.htp.jd2.maksimkosmachev.test.command.impl.GoToMainPage;
import by.htp.jd2.maksimkosmachev.test.command.impl.GoToSignInPage;
import by.htp.jd2.maksimkosmachev.test.command.impl.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

final public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION,new RegistrationCommand());
        commands.put(CommandName.GO_TO_SIGN_IN_PAGE,new GoToSignInPage());
        commands.put(CommandName.GO_TO_MAIN_PAGE,new GoToMainPage());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }
}
