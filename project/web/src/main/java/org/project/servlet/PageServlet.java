package org.project.servlet;

import org.progect.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pages", ProjectService.getInstance().getPages());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages.jsp")
                .forward(req, resp);

    }
}


