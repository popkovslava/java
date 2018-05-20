package org.progect.service;

import java.util.List;
import org.project.dao.PagesDao;
import org.project.entity.Pages;

public class ProjectService {

    private static final ProjectService INSTANCE = new ProjectService();

    public List<Pages> getPages() {
        return PagesDao.getInstance().findAll();
    }

    public void setText(String text){
        Pages pages=new Pages();
        pages.setTitle(text);
        pages.setDescription(text);
        PagesDao.getInstance().save(pages);
    }

    public static ProjectService getInstance() {
        return INSTANCE;
    }
}
