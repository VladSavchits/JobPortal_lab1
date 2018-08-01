import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.service.impl.EmployerServiceImpl;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by AR on 21.05.2017.
 */
public class EmployerDAOTest {

    @Test
    public void getAllEmployersTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        ArrayList<Employer> employers = employerService.getAllEntities();
        assertNotNull(employers);
    }

    @Test(timeout = 10000)
    public void getAllEmployersCheckTimeoutTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        employerService.getAllEntities();
    }

    @Test(expected = NullPointerException.class)
    public void tryAddNullEmployerTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        employerService.addEntity(null);
    }

    @Test
    public void addEmployerTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Employer employer = new Employer();
        employer.setUser_id(5);
        employer.setEmployer_name("test");
        employer.setEmployer_information("test");
        Integer employer_id = employerService.getEmployerIdByUserId(employer.getUser_id());
        employerService.deleteEntity(employer_id);
        employerService.addEntity(employer);
    }

    @Test(expected = ServiceException.class)
    public void tryAddDuplicateEmployerTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Employer employer = new Employer();
        employer.setUser_id(5);
        employer.setEmployer_name("test");
        employer.setEmployer_information("test");
        employerService.addEntity(employer);
        employerService.addEntity(employer);
    }

    @Test
    public void tryFindEmployerByIdTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Integer employer_id = employerService.getEmployerIdByUserId(9999);
        assertNull(employer_id);
    }

    @Test
    public void findEmployerByIdTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Employer employer = new Employer();
        employer.setUser_id(5);
        employer.setEmployer_name("test");
        employer.setEmployer_information("test");
        Integer userId = employerService.getEmployerIdByUserId(employer.getUser_id());
        Employer foundEmployer = employerService.getEntityById(userId);
        assertEquals(foundEmployer.getEmployer_name(), employer.getEmployer_name());
    }

    @Test
    public void updateEmployerTest() throws ServiceException, DAOException {
        String newInfo = "test_info";
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Employer employer = new Employer();
        employer.setUser_id(5);
        employer.setEmployer_name("test");
        employer.setEmployer_information("test");
        employer.setEmployer_information(newInfo);
        employerService.updateEntity(employer);
        assertEquals(employer.getEmployer_information(), newInfo);
    }

    @Test(expected = NullPointerException.class)
    public void updateNullEmployerTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        employerService.updateEntity(null);
    }

    @Test
    public void deleteEmployerTest() throws ServiceException, DAOException {
        EmployerServiceImpl employerService = new EmployerServiceImpl();
        Employer employer = new Employer();
        employer.setUser_id(5);
        employer.setEmployer_name("test");
        employer.setEmployer_information("test");
        Integer employer_id = employerService.getEmployerIdByUserId(employer.getUser_id());
        employerService.deleteEntity(employer_id);
        employer_id = employerService.getEmployerIdByUserId(employer_id);
        assertNull(employer_id);
    }

}
