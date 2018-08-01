package by.bsuir.jobproject.command.impl.user;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.service.UserService;
import by.bsuir.jobproject.service.impl.UserServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToUpdateUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        String page = ConfigurationManager.getProperty("path.page.edit_user");
        int userId = Integer.parseInt(request.getParameter("user_id"));
        UserService userService = new UserServiceImpl();

        try {
            User user = userService.getEntityById(userId);
            request.setAttribute("user", user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}