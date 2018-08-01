package by.bsuir.jobproject.command.impl.vacancy;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import by.bsuir.jobproject.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.vacancies");
        Vacancy vacancy = new Vacancy();

        vacancy.setEmployer_id(Integer.parseInt(request.getParameter("employer_id")));
        vacancy.setVacancy_name(request.getParameter("vacancy_name"));
        vacancy.setVacancy_requirements(request.getParameter("vacancy_requirements"));
        vacancy.setVacancy_payment(request.getParameter("vacancy_payment"));

        VacancyServiceImpl vacancyService = new VacancyServiceImpl();

        try {
            vacancyService.addEntity(vacancy);
            request.setAttribute("vacancies", vacancyService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
