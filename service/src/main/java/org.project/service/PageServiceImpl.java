package org.project.service;

import org.project.entity.Pages;
import org.project.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PageServiceImpl implements PageService {

    private final PagesRepository pagesRepository;

    @Autowired
    public PageServiceImpl(PagesRepository pagesRepository) {
        this.pagesRepository = pagesRepository;
    }

    public PagesRepository pages() {
        return pagesRepository;
    }

    public void pagesRun() {
        Pages pages = new Pages();
        pages.setTitle("Title");
        pages.setDescription("Description");
        pagesRepository.save(pages);
    }
}
