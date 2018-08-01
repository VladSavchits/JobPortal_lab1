package by.bsuir.jobproject.command.impl.employer;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.service.impl.EmployerServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToUpdateEmployerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.edit_employer");
        int employerId = Integer.parseInt(request.getParameter("employer_id"));
        EmployerServiceImpl employerService = new EmployerServiceImpl();

        try {
            Employer employer = employerService.getEntityById(employerId);
            request.setAttribute("employer", employer);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
