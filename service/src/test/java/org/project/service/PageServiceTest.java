package org.project.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hibernate.SessionFactory;
import org.junit.runners.MethodSorters;
import org.project.dao.PagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/application-context.xml")
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PageServiceTest {

    @Autowired
    private PageService pageService;

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    private PagesRepository pagesDao;

    @Test
    public void test1() {
        System.out.println();
    }

//    @Test
//    @Transactional
//    public void atestFindOn() {
//        Long id = pageService.save(new Pages("test"));
//        TestCase.assertNotNull(id);
//    }

}