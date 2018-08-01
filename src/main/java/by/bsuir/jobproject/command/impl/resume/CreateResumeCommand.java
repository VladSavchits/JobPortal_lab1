package by.bsuir.jobproject.command.impl.resume;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.service.impl.ResumeServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateResumeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.resumes");

        Resume resume = new Resume();

        //user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        resume.setJobseeker_id(Integer.parseInt(request.getParameter("jobseeker_id")));
        resume.setSpecialty_id(Integer.parseInt(request.getParameter("specialty_id")));
        resume.setSkill_id(Integer.parseInt(request.getParameter("skill_id")));
        resume.setResume_information(request.getParameter("resume_information"));

        ResumeServiceImpl resumeService = new ResumeServiceImpl();


        try {
            resumeService.addEntity(resume);
            request.setAttribute("resumes", resumeService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
