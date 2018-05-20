package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.Lang;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class LangDaoTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Lang ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Lang menu =new Lang();
        menu.setLn("Test");
        menu.setLn_title("tester");
        Serializable serializable=LangDao.getInstance().save(menu);
        assertNotNull("Id is null", serializable);
    }

    @Test
    public void checkFindById() {
        Lang menu =new Lang();
        menu.setLn("Check Find By");
        LangDao.getInstance().save(menu);
        Lang obj= LangDao.getInstance().findById(1L);
        assertNotNull("Id is null", obj);
    }

    @Test
    public void findAll() {
        List<Lang> menus=LangDao.getInstance().findAll();
        assertNotNull("Id is null", menus);
    }

    @Test
    public void update() {
        Lang menu =new Lang();
        menu.setId(1l);
        menu.setLn("Check Update");
        LangDao.getInstance().update(menu);
    }

    @Test
    public void delete() {
        Lang lang=new Lang();
        lang.setLn("TEST");
        LangDao.getInstance().save(lang);
        LangDao.getInstance().delete(LangDao.getInstance().findById(1L));
        assertNull("Id is not null", LangDao.getInstance().findById(1L));
    }

}