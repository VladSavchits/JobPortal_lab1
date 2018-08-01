package by.bsuir.jobproject.controller;


import by.bsuir.jobproject.command.ActionCommand;
import by.bsuir.jobproject.command.factory.ActionFactory;
import by.bsuir.jobproject.exception.CommandException;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MessageManager;
import com.itextpdf.text.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/controller")
public class AppServlet extends HttpServlet {


    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);

        try {
            try {
                page = (String) command.execute(request, response);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            if (page != null) {
                request.getRequestDispatcher(page).forward(request, response);
            } else {
                page = ConfigurationManager.getProperty("path.page.index");
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }

    }

}
