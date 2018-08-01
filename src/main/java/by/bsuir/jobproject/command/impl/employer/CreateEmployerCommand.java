package by.bsuir.jobproject.command.impl.employer;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.service.impl.EmployerServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateEmployerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.employers");

        Employer employer = new Employer();

        //user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        employer.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        employer.setEmployer_name(request.getParameter("employer_name"));
        employer.setEmployer_information(request.getParameter("employer_information"));

        EmployerServiceImpl employerService = new EmployerServiceImpl();


        try {
            employerService.addEntity(employer);
            request.setAttribute("employers", employerService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
