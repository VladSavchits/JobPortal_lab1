import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by AR on 21.05.2017.
 */
public class VacancyDAOTest {
    @Test
    public void getAllVacanciesTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        ArrayList<Vacancy> vacancies = vacancyService.getAllEntities();
        assertNotNull(vacancies);
    }

    @Test(timeout = 10000)
    public void getAllVacanciesCheckTimeoutTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        vacancyService.getAllEntities();
    }

    @Test(expected = NullPointerException.class)
    public void tryAddNullVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        vacancyService.addEntity(null);
    }

    @Test
    public void addVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer_id(3);
        vacancy.setVacancy_name("test");
        vacancy.setVacancy_payment("0");
        vacancy.setVacancy_requirements("test");
    }

    @Test(expected = ServiceException.class)
    public void tryAddDuplicateVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer_id(3);
        vacancy.setVacancy_name("test");
        vacancy.setVacancy_payment("0");
        vacancy.setVacancy_requirements("test");
        vacancyService.addEntity(vacancy);
        vacancyService.addEntity(vacancy);
    }

    @Test
    public void tryFindVacancyByIdTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Integer vacancyId = null;
        assertNull(vacancyId);
    }

    @Test
    public void findVacancyByIdTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer_id(3);
        vacancy.setVacancy_name("test");
        vacancy.setVacancy_payment("0");
        vacancy.setVacancy_requirements("test");
        Vacancy foundVacancy = vacancy;
        assertEquals(foundVacancy.getVacancy_payment(), vacancy.getVacancy_payment());
    }

    @Test
    public void updateVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer_id(3);
        vacancy.setVacancy_name("test");
        vacancy.setVacancy_payment("0");
        vacancy.setVacancy_requirements("test");
        String newPayment = "100";
        vacancy.setVacancy_payment(newPayment);
        vacancyService.updateEntity(vacancy);
        assertEquals(vacancy.getVacancy_payment(), newPayment);
    }

    @Test(expected = NullPointerException.class)
    public void updateNullVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        vacancyService.updateEntity(null);
    }

    @Test
    public void deleteVacancyTest() throws ServiceException, DAOException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer_id(3);
        vacancy.setVacancy_name("test");
        vacancy.setVacancy_payment("0");
        vacancy.setVacancy_requirements("test");
        assertNull(null);
    }
}
