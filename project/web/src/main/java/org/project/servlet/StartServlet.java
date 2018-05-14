package org.project.servlet;

import org.progect.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")

public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", ProjectService.getInstance().getPost());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/posts.jsp")
                .forward(req, resp);

    }

}


