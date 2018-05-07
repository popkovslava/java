package org.project.servlet;

import org.progect.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu1")

public class Page1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("request1", ProjectService.getInstance().StartEntity());
        req.setAttribute("request2", ProjectService.getInstance().MenuEntity());
        req.setAttribute("request3", ProjectService.getInstance().TextEntity());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/page1.jsp")
                .forward(req, resp);
    }
}
