package by.bsuir.jobproject.service;


import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import com.itextpdf.text.DocumentException;

import java.util.Map;

public interface DocumentBuilderService {
    DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException, DocumentException;
}



















































































