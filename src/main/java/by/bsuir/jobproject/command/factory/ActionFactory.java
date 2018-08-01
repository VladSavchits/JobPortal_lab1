package by.bsuir.jobproject.command.factory;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.command.CommandEnum;
import by.bsuir.jobproject.command.impl.EmptyCommand;
import by.bsuir.jobproject.util.MessageManager;

import javax.servlet.http.HttpServletRequest;


public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCommand();

        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return command;
    }

}
