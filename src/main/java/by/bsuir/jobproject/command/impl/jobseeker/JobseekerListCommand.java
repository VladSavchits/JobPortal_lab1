package by.bsuir.jobproject.command.impl.jobseeker;

import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by AR on 30.04.2017.
 */
public class JobseekerListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.jobseekers");

        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        try {
            ArrayList<Jobseeker> jobseekers;
            jobseekers = jobseekerService.getAllEntities();
            request.setAttribute("jobseekers", jobseekers);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
