package org.project.service;

import org.project.repository.PagesRepository;
import org.springframework.stereotype.Component;

@Component
public interface PageService {

    PagesRepository pages();

    void pagesRun();
}
