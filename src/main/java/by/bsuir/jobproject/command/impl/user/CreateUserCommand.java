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


public class CreateUserCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.users");

        User user = new User();

        user.setUser_login(request.getParameter("user_login"));
        user.setUser_password(request.getParameter("user_password"));
        user.setUser_email(request.getParameter("user_email"));
        user.setUser_status(request.getParameter("user_status"));

        UserService userService = new UserServiceImpl();

        try {
            userService.addEntity(user);
            request.setAttribute("users", userService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
