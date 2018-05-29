package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Lang;
import org.project.entity.LnagPages;
import org.project.entity.Pages;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LangPagesDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from LnagPages");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Pages pg = new Pages();
        pg.setTitle("Save");
        PagesDaoImpl.getInstance().save(pg);
        Lang ln = new Lang();
        ln.setLnTitle("Save");
        ln.setLn("Save");
        LangDaoImpl.getInstance().save(ln);
        LnagPages list = new LnagPages();
        list.setPages(pg);
        list.setLang(ln);
        Serializable lis = LangPagesDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<LnagPages> list = LangPagesDaoImpl.getInstance().findAll();
        for (LnagPages li : list) {
            assertNotNull("Id is null", LangPagesDaoImpl.getInstance().findById(li.getId()));
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<LnagPages> list = LangPagesDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        Pages pg = new Pages();
        pg.setTitle("Update");
        PagesDaoImpl.getInstance().save(pg);
        Lang ln = new Lang();
        ln.setLnTitle("Update");
        LangDaoImpl.getInstance().save(ln);

        List<LnagPages> list = LangPagesDaoImpl.getInstance().findAll();
        for (LnagPages li : list) {
            li.setLang(ln);
            li.setPages(pg);
            LangPagesDaoImpl.getInstance().update(li);
        }
    }


    @Test(priority = 5)
    public void delete() {
        List<LnagPages> list = LangPagesDaoImpl.getInstance().findAll();
        for (LnagPages li : list) {
            LangPagesDaoImpl.getInstance().delete(LangPagesDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}