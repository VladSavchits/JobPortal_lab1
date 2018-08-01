package by.bsuir.jobproject.documentbuilder;


import by.bsuir.jobproject.service.DocumentBuilderService;
import by.bsuir.jobproject.service.documentservice.impl.EmployerDocumentBuilderService;
import by.bsuir.jobproject.service.documentservice.impl.FreeJobseekerCsvBuilderService;
import by.bsuir.jobproject.service.documentservice.impl.FreeJobseekerXlsBuilderService;
import by.bsuir.jobproject.service.documentservice.impl.VacanciesCsvBuilderService;

import java.util.HashMap;
import java.util.Map;

public final class DocumentBuilderMapper implements DocumentBuilderServiceFactory {

    final private static Map<String, DocumentBuilderService> builderMap = new HashMap();

    static {
        builderMap.put("USER_DOCUMENT", new EmployerDocumentBuilderService());
        builderMap.put("FREE_JOBSEEKERS", new FreeJobseekerCsvBuilderService());
        builderMap.put("VACANCIES", new VacanciesCsvBuilderService());
        builderMap.put("FREE_JOBSEEKERS_XLS", new FreeJobseekerXlsBuilderService());
    }

    private static class Holder{
        private final static DocumentBuilderMapper INSTANCE = new DocumentBuilderMapper();
    }

    public static DocumentBuilderMapper getInstance(){
        return Holder.INSTANCE;
    }

    public DocumentBuilderService getDocumentBuilderService(String documentName) {
        return builderMap.get(documentName.toUpperCase());
    }
}
