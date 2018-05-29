package org.progect.service;

import java.util.List;
import org.project.dao.PagesDaoImpl;

public class PageService {
    private static final PageService INSTANCE = new PageService();

    public List getPageWithMenu() {
        return PagesDaoImpl.getInstance().getPageWithMenu();
    }

    public List getPageByMenu(String slug) {
        return slug != null ? PagesDaoImpl.getInstance().getPageBySlug(slug.toLowerCase()) : null;
    }

    public static PageService getInstance() {
        return INSTANCE;
    }
}
