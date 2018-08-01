package by.bsuir.jobproject.command.impl;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.service.impl.UserServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.index");
        String errorString;
        UserServiceImpl userService = new UserServiceImpl();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null && login.length() != 0 && password.length() != 0) {

            User user;
            try {
                user = userService.findUser(login, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("user_status", user.getUser_status());
                } else {
                    request.setAttribute("errorString", "Login or password invalid!");
                    page = ConfigurationManager.getProperty("path.page.login");
                    return page;
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("errorString", "Required login and password!");
            page = ConfigurationManager.getProperty("path.page.login");
            return page;
        }
        return page;
    }
}
