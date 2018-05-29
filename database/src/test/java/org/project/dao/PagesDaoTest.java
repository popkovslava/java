package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Menu;
import org.project.entity.Pages;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class PagesDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Pages");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Pages list = new Pages();
        Menu menu = new Menu();
        menu.setTitle("Save");
        MenuDaoImpl.getInstance().save(menu);
        list.setTitle("Save");
        list.setDescription("Save");
        list.setMenu(menu);
        Serializable lis = PagesDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Pages> list = PagesDaoImpl.getInstance().findAll();
        for (Pages li : list) {
            Pages ln = PagesDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Pages> list = PagesDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Pages> list = PagesDaoImpl.getInstance().findAll();
        for (Pages li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Update");
            PagesDaoImpl.getInstance().update(li);
            Pages news = PagesDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Pages> list = PagesDaoImpl.getInstance().findAll();
        for (Pages li : list) {
            PagesDaoImpl.getInstance().delete(PagesDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }
}