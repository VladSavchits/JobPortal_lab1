import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class JobseekerDAOTest {

    @Test
    public void getAllJobseekersTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        ArrayList<Jobseeker> jobseekers = jobseekerService.getAllEntities();
        assertNotNull(jobseekers);
    }

    @Test(timeout = 10000)
    public void getAllJobseekersCheckTimeoutTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        jobseekerService.getAllEntities();
    }

    @Test(expected = NullPointerException.class)
    public void tryAddNullJobseekerTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        jobseekerService.addEntity(null);
    }

    @Test
    public void addJobseekerTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUser_id(1);
        jobseeker.setJobseeker_lastname("test");
        jobseeker.setJobseeker_name("test");
        jobseeker.setJobseeker_status("test");
        jobseekerService.addEntity(jobseeker);
    }

    @Test(expected = ServiceException.class)
    public void tryAddDuplicateJobseekerTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUser_id(1);
        jobseeker.setJobseeker_lastname("test");
        jobseeker.setJobseeker_name("test");
        jobseeker.setJobseeker_status("test");
        jobseekerService.addEntity(jobseeker);
        jobseekerService.addEntity(jobseeker);
    }

    @Test
    public void tryFindJobseekerByIdTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Integer jobseekerId = jobseekerService.getJobseekerIdByUserId(9999);
        assertNull(jobseekerId);
    }

    @Test
    public void findJobseekerByIdTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUser_id(1);
        jobseeker.setJobseeker_lastname("test");
        jobseeker.setJobseeker_name("test");
        jobseeker.setJobseeker_status("test");
        Integer jobseekerId = jobseekerService.getJobseekerIdByUserId(jobseeker.getUser_id());
        Jobseeker foundJobseeker = jobseekerService.getEntityById(jobseekerId);
        assertEquals(foundJobseeker.getUser_id(), jobseeker.getUser_id());
    }

    @Test
    public void updateJobseekerTest() throws ServiceException, DAOException {
        String newStatus = "test_status";
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUser_id(1);
        jobseeker.setJobseeker_lastname("test");
        jobseeker.setJobseeker_name("test");
        jobseeker.setJobseeker_status("test");
        jobseeker.setJobseeker_status(newStatus);
        jobseekerService.updateEntity(jobseeker);
        assertEquals(jobseeker.getJobseeker_status(), newStatus);
    }

    @Test(expected = NullPointerException.class)
    public void updateNullJobseekerTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        jobseekerService.updateEntity(null);
    }

    @Test
    public void deleteJobseekerTest() throws ServiceException, DAOException {
        JobseekerServiceImpl jobseekerService = new JobseekerServiceImpl();
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUser_id(1);
        jobseeker.setJobseeker_lastname("test");
        jobseeker.setJobseeker_name("test");
        jobseeker.setJobseeker_status("test");
        Integer jobseeker_id = jobseekerService.getJobseekerIdByUserId(jobseeker.getUser_id());
        jobseekerService.deleteEntity(jobseeker_id);
        jobseeker_id = jobseekerService.getJobseekerIdByUserId(jobseeker_id);
        assertNull(jobseeker_id);
    }

}
