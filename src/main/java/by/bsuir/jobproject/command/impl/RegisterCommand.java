package by.bsuir.jobproject.command.impl;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import by.bsuir.jobproject.service.impl.UserServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.login");

        UserServiceImpl userService = new UserServiceImpl();
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();

        try {
            User user = new User();
            user.setUser_login(request.getParameter("login"));
            user.setUser_password(request.getParameter("password"));
            user.setUser_email(request.getParameter("email"));
            user.setUser_status("jobseeker");

            userService.addEntity(user);

            int userId = userService.getUserIdByLogin(user.getUser_login());

            Jobseeker jobseeker = new Jobseeker();
            jobseeker.setUser_id(userId);
            jobseeker.setJobseeker_lastname(request.getParameter("lastname"));
            jobseeker.setJobseeker_name(request.getParameter("name"));
            jobseeker.setJobseeker_status("free");

            jobseekerService.addEntity(jobseeker);


        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
