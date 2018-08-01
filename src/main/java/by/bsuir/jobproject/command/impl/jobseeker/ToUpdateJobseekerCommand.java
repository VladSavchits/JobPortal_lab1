package by.bsuir.jobproject.command.impl.jobseeker;

import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by AR on 30.04.2017.
 */
public class ToUpdateJobseekerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.edit_jobseeker");
        int jobseekerId = Integer.parseInt(request.getParameter("jobseeker_id"));
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();

        try {
            Jobseeker jobseeker = jobseekerService.getEntityById(jobseekerId);
            request.setAttribute("jobseeker", jobseeker);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
