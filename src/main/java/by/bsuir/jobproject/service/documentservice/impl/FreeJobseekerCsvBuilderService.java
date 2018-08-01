package by.bsuir.jobproject.service.documentservice.impl;

import by.bsuir.jobproject.documentbuilder.CsvDocumentBuilder;
import by.bsuir.jobproject.documentbuilder.DocumentBuilder;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import by.bsuir.jobproject.service.Service;
import by.bsuir.jobproject.service.DocumentBuilderService;
import by.bsuir.jobproject.service.impl.JobseekerServiceImpl;
import com.itextpdf.text.DocumentException;

import java.util.List;
import java.util.Map;

/**
 * Created by AR on 24.05.2017.
 */
public class FreeJobseekerCsvBuilderService implements DocumentBuilderService {
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException, DocumentException {
        Service jobseekerService = new JobseekerServiceImpl();
        List<?> resultList = jobseekerService.getAllEntities();
        DocumentBuilder<List<?>> documentBuilder = new CsvDocumentBuilder<>("company_vacancies".concat(".csv"));
        return documentBuilder.buildDocument(resultList);
    }
}
