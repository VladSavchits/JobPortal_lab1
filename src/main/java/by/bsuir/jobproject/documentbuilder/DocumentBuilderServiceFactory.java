package by.bsuir.jobproject.documentbuilder;


import by.bsuir.jobproject.service.DocumentBuilderService;

public interface DocumentBuilderServiceFactory {
    DocumentBuilderService getDocumentBuilderService(String documentName);
}
