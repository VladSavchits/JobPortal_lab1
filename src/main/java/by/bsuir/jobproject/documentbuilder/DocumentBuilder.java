package by.bsuir.jobproject.documentbuilder;


import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import com.itextpdf.text.DocumentException;

public interface DocumentBuilder<T> {
    DocumentObject buildDocument(T documentData) throws ServiceException, DocumentException;
}
