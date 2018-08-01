package by.bsuir.jobproject.command.impl.vacancy;

import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by AR on 29.04.2017.
 */
public class    ToUpdateVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.edit_vacancy");
        int userId = Integer.parseInt(request.getParameter("vacancy_id"));
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();

        try {
            Vacancy vacancy = vacancyService.getEntityById(userId);
            request.setAttribute("vacancy", vacancy);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}