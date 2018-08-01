package by.bsuir.jobproject.command.impl.resume;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.service.impl.ResumeServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToUpdateResumeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.edit_resume");
        int resumeId = Integer.parseInt(request.getParameter("resume_id"));
        ResumeServiceImpl resumeService = new ResumeServiceImpl();

        try {
            Resume resume = resumeService.getEntityById(resumeId);
            request.setAttribute("resume", resume);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
