package by.bsuir.jobproject.command.impl.resume;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.service.impl.ResumeServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class ResumeListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.resumes");

        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        try {
            ArrayList<Resume> resumes;
            resumes = resumeService.getAllEntities();
            request.setAttribute("resumes", resumes);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
