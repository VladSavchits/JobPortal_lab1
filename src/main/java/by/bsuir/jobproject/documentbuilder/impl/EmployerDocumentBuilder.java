package by.bsuir.jobproject.documentbuilder.impl;


import by.bsuir.jobproject.documentbuilder.PdfDocumentBuilder;
import by.bsuir.jobproject.model.Employer;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

public class EmployerDocumentBuilder extends PdfDocumentBuilder<Employer> {
    private EmployerDocumentBuilder(){
        super("/documents/employer.pdf", "employer.pdf");
    }

    private static class Holder{
        private final static EmployerDocumentBuilder INSTANCE = new EmployerDocumentBuilder();
    }

    public static EmployerDocumentBuilder getInstance(){
        return Holder.INSTANCE;
    }

    @Override
    protected void setFields(AcroFields form, Employer documentData) throws DocumentException{
        try {
            form.setField("employer_name", documentData.getEmployer_name());
            form.setField("employer_info", documentData.getEmployer_information());
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}
