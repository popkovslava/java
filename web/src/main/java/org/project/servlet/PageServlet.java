package org.project.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.project.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(urlPatterns = {"/"})
public class PageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PageService pageService;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List menu = pageService.getPage();
        List page = pageService.getPageBySlug(req.getParameter("page"));
        req.setAttribute("menu", menu);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, res);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
