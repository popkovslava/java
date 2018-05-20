package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.Menu;
import org.project.entity.Pages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;



public class PagesDaoTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Pages ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Pages pages =new Pages();
        pages.setTitle("SLON CLASS");
        pages.setDescription("test");
        Serializable serializable=PagesDao.getInstance().save(pages);
        assertNotNull("Id is null", serializable);
    }

    @Test
    public void checkFindById() {
        Pages pages=new Pages();
        pages.setTitle("Check Find By");
        PagesDao.getInstance().save(pages);
        Pages obj= PagesDao.getInstance().findById(1L);
        assertNotNull("Id is null", obj);
    }

    @Test
    public void findAll() {
        List<Pages> pages=PagesDao.getInstance().findAll();
        assertNotNull("Id is null", pages);
    }

    @Test
    public void update() {
        Pages pages =new Pages();
        pages.setId(1l);
        pages.setTitle("Check Update");
        PagesDao.getInstance().update(pages);
    }

    @Test
    public void delete() {
        Pages menu =new Pages();
        menu.setTitle("SLON CLASS");
        PagesDao.getInstance().save(menu);
        PagesDao.getInstance().delete(PagesDao.getInstance().findById(1L));
        assertNull("Id is not null", PagesDao.getInstance().findById(1L));
    }

}