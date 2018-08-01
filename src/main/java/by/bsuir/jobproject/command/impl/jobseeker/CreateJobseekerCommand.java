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
public class CreateJobseekerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.jobseekers");

        Jobseeker jobseeker = new Jobseeker();

        jobseeker.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        jobseeker.setJobseeker_lastname(request.getParameter("jobseeker_lastname"));
        jobseeker.setJobseeker_name(request.getParameter("jobseeker_name"));
        jobseeker.setJobseeker_status(request.getParameter("jobseeker_status"));

        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();

        try {
            jobseekerService.addEntity(jobseeker);
            request.setAttribute("jobseekers", jobseekerService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
