package by.bsuir.jobproject.service.documentservice.impl;

import by.bsuir.jobproject.documentbuilder.DocumentBuilder;
import by.bsuir.jobproject.documentbuilder.impl.FreeJobseekersDocumentBuilder;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.service.DocumentBuilderService;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import com.itextpdf.text.DocumentException;

import java.util.List;
import java.util.Map;

/**
 * Created by AR on 24.05.2017.
 */
public class FreeJobseekerXlsBuilderService implements DocumentBuilderService {
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException, DocumentException {
        List<Jobseeker> jobseekers = new JobseekerServiceImpl().getAllEntities();
        if(jobseekers != null){
            DocumentBuilder documentBuilder = FreeJobseekersDocumentBuilder.getInstance();
            return documentBuilder.buildDocument(jobseekers);
        }
        return null;
    }
}
