package by.bsuir.jobproject.service.documentservice.impl;

import by.bsuir.jobproject.documentbuilder.CsvDocumentBuilder;
import by.bsuir.jobproject.documentbuilder.DocumentBuilder;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import by.bsuir.jobproject.service.DocumentBuilderService;
import by.bsuir.jobproject.service.impl.VacancyServiceImpl;
import com.itextpdf.text.DocumentException;

import java.util.List;
import java.util.Map;

/**
 * Created by AR on 24.05.2017.
 */
public class VacanciesCsvBuilderService implements DocumentBuilderService {
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException, DocumentException {
        VacancyServiceImpl vacancyService = new VacancyServiceImpl();
        List<?> resultList = vacancyService.getEntitiesByEmployer(Integer.parseInt(documentInfo.get("id")[0]));
        DocumentBuilder<List<?>> documentBuilder = new CsvDocumentBuilder<>("company_vacancies".concat(".csv"));
        return documentBuilder.buildDocument(resultList);
    }
}
