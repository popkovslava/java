package org.project.servlet;


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
//        List page = PageService.getInstance().getPageByMenu(req.getParameter("page"));
//        List menu = PageService.getInstance().getPageWithMenu();
//        req.setAttribute("page", page);
//        req.setAttribute("menu", menu);
//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}




