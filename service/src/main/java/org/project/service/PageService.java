package org.project.service;

import java.util.List;
import org.project.dao.Interface.PagesDao;
import org.project.entity.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PageService {

    @Autowired
    private final PagesDao pagesDao;

    public PageService(PagesDao pagesDao) {
        this.pagesDao = pagesDao;
    }

    public List<Pages> getPageBySlug(String slug) {
        return slug != null ? pagesDao.getPageBySlug(slug.toLowerCase()) : null;
    }

    public List<Pages> getPage() {
        return pagesDao.getPage();
    }

}
