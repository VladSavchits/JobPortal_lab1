package by.bsuir.jobproject.command.impl.user;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.service.impl.UserServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class UserListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        String page = ConfigurationManager.getProperty("path.page.users");

        UserServiceImpl userService = new UserServiceImpl();
        try {
            ArrayList<User> users;
            users = userService.getAllEntities();
            request.setAttribute("users", users);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
