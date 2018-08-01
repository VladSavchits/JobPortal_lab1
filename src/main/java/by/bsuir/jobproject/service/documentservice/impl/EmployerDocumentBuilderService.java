package by.bsuir.jobproject.service.documentservice.impl;

import by.bsuir.jobproject.documentbuilder.DocumentBuilder;
import by.bsuir.jobproject.documentbuilder.impl.EmployerDocumentBuilder;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.service.DocumentBuilderService;
import by.bsuir.jobproject.service.impl.EmployerServiceImpl;
import com.itextpdf.text.DocumentException;

import java.util.Map;

public class EmployerDocumentBuilderService implements DocumentBuilderService {
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException, DocumentException {
        Employer employer = new EmployerServiceImpl().getEntityById(Integer.parseInt(documentInfo.get("id")[0]));
        if(employer != null) {
            DocumentBuilder employerDocumentBuilder = EmployerDocumentBuilder.getInstance();
            return employerDocumentBuilder.buildDocument(employer);
        }
        return null;
    }
}
