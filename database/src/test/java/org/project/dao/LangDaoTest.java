package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Lang;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class LangDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Lang");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Lang list = new Lang();
        list.setLn("Save");
        list.setLnTitle("Save");
        Serializable lis = LangDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Lang> list = LangDaoImpl.getInstance().findAll();
        for (Lang li : list) {
            Lang ln = LangDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Lang> list = LangDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Lang> list = LangDaoImpl.getInstance().findAll();
        for (Lang li : list) {
            String old = li.getLnTitle();
            li.setId(li.getId());
            li.setLn("Update");
            li.setLnTitle("Update");
            LangDaoImpl.getInstance().update(li);
            Lang news = LangDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getLnTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Lang> list = LangDaoImpl.getInstance().findAll();
        for (Lang li : list) {
            LangDaoImpl.getInstance().delete(LangDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }
}