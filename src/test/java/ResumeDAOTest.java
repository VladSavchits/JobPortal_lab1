import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.service.impl.ResumeServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by AR on 21.05.2017.
 */
public class ResumeDAOTest {

    @Test
    public void getAllResumesTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        ArrayList<Resume> resumes = resumeService.getAllEntities();
        assertNotNull(resumes);
    }

    @Test(timeout = 10000)
    public void getAllResumesCheckTimeoutTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        resumeService.getAllEntities();
    }

    @Test(expected = NullPointerException.class)
    public void tryAddNullResumeTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        resumeService.addEntity(null);
    }

    @Test
    public void addResumeTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Resume resume = new Resume();
        resume.setJobseeker_id(1);
        resume.setSpecialty_id(1);
        resume.setSkill_id(1);
        resume.setResume_information("text");
        Integer resume_id = resumeService.getResumeIdByJobseekerId(resume.getJobseeker_id());
        resumeService.deleteEntity(resume_id);
        resumeService.addEntity(resume);
        assertNotNull(resume);
    }

    @Test(expected = ServiceException.class)
    public void tryAddDuplicateResumeTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Resume resume = new Resume();
        resume.setJobseeker_id(1);
        resume.setSpecialty_id(1);
        resume.setSkill_id(1);
        resume.setResume_information("text");
        resumeService.addEntity(resume);
        resumeService.addEntity(resume);
    }

    @Test
    public void tryFindResumeByIdTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Integer resume_id = resumeService.getResumeIdByJobseekerId(9999);
        assertNull(resume_id);
    }

    @Test
    public void findResumeByIdTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Resume resume = new Resume();
        resume.setJobseeker_id(1);
        resume.setSpecialty_id(1);
        resume.setSkill_id(1);
        resume.setResume_information("text");
        Integer userId = resumeService.getResumeIdByJobseekerId(resume.getJobseeker_id());
        Resume foundResume = resumeService.getEntityById(userId);
        assertEquals(foundResume.getResume_information(), resume.getResume_information());
    }

    @Test
    public void updateResumeTest() throws ServiceException, DAOException {
        String newInfo = "test_info";
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Resume resume = new Resume();
        resume.setJobseeker_id(1);
        resume.setSpecialty_id(1);
        resume.setSkill_id(1);
        resume.setResume_information("text");
        resume.setResume_information(newInfo);
        resumeService.updateEntity(resume);
        assertEquals(resume.getResume_information(), newInfo);
    }

    @Test(expected = NullPointerException.class)
    public void updateNullResumeTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        resumeService.updateEntity(null);
    }

    @Test
    public void deleteResumeTest() throws ServiceException, DAOException {
        ResumeServiceImpl resumeService = new ResumeServiceImpl();
        Resume resume = new Resume();
        resume.setJobseeker_id(1);
        resume.setSpecialty_id(1);
        resume.setSkill_id(1);
        resume.setResume_information("text");
        resumeService.updateEntity(resume);
        Integer resume_id = resumeService.getResumeIdByJobseekerId(resume.getJobseeker_id());
        resumeService.deleteEntity(resume_id);
        resume_id = resumeService.getResumeIdByJobseekerId(resume_id);
        assertNull(resume_id);
    }

}
