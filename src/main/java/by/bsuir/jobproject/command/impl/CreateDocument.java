package by.bsuir.jobproject.command.impl;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.documentbuilder.DocumentBuilderMapper;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.DocumentObject;
import by.bsuir.jobproject.service.DocumentBuilderService;
import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CreateDocument implements ActionCommand {
    public Object execute(HttpServletRequest req, HttpServletResponse response) throws CommandException, DocumentException {
        Map<String, String[]> requestParams = req.getParameterMap();
        DocumentObject documentObject;
        try {
            DocumentBuilderMapper documentBuilderMapper = DocumentBuilderMapper.getInstance();
            DocumentBuilderService documentBuilderService = documentBuilderMapper.getDocumentBuilderService(requestParams.get("docname")[0]);
            documentObject = documentBuilderService.buildDocument(requestParams);
            sendDocument(response, documentObject);
        }catch (ServiceException | IOException e){
            throw new CommandException(e);
        }
        return null;
    }

    private void sendDocument(HttpServletResponse response, DocumentObject documentObject) throws IOException{
        if(documentObject != null){
            response.setContentType(documentObject.getMimeType());
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", documentObject.getDocumentName()));
            response.getOutputStream().write(documentObject.getDocumentBytes());
            response.getOutputStream().close();
        }
    }
}
