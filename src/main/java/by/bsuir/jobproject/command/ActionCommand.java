package by.bsuir.jobproject.command;


import by.bsuir.jobproject.exception.CommandException;
import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ActionCommand {
    Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, DocumentException;
}
