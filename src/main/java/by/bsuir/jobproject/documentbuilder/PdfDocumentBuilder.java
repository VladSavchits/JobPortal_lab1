package by.bsuir.jobproject.documentbuilder;


import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class PdfDocumentBuilder<T> implements DocumentBuilder<T> {
    private final String TEMPLATE_PATH, DOCUMENT_NAME;
    private final static String MIME_TYPE = "application/pdf";

    public PdfDocumentBuilder(String templatePath, String documentName){
        TEMPLATE_PATH = templatePath;
        DOCUMENT_NAME = documentName;
    }

    public final DocumentObject buildDocument(T documentData) throws ServiceException, DocumentException {
        DocumentObject documentObject = null;
        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            pdfReader = new PdfReader(classLoader.getResourceAsStream(TEMPLATE_PATH));
            pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
            pdfStamper.setFormFlattening(true);
            final BaseFont baseFont = BaseFont.createFont("c:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            final AcroFields form = pdfStamper.getAcroFields();
            form.addSubstitutionFont(baseFont);
            setFields(form, documentData);
        }catch (IOException | DocumentException e){
            throw new ServiceException(e);
        }finally {
            try {
                if(pdfStamper != null){
                    pdfStamper.close();
                    documentObject = fillDocumentObject(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                }
            }catch (DocumentException | IOException e){

            }finally {
                if (pdfReader != null){
                    pdfReader.close();
                }
            }
        }
        return documentObject;
    }

    private DocumentObject fillDocumentObject(ByteArrayOutputStream byteArrayOutputStream){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        documentObject.setMimeType(MIME_TYPE);
        documentObject.setDocumentBytes(byteArrayOutputStream.toByteArray());
        return documentObject;
    }

    protected abstract void setFields(AcroFields form, T documentData) throws DocumentException, IOException;
}
