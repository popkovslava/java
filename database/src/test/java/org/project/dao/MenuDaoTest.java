package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Menu;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class MenuDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Menu");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Menu list = new Menu();
        list.setTitle("Save");
        Serializable lis = MenuDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Menu> list = MenuDaoImpl.getInstance().findAll();
        for (Menu li : list) {
            Menu ln = MenuDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Menu> list = MenuDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Menu> list = MenuDaoImpl.getInstance().findAll();
        for (Menu li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Update");
            MenuDaoImpl.getInstance().update(li);
            Menu news = MenuDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Menu> list = MenuDaoImpl.getInstance().findAll();
        for (Menu li : list) {
            li.setId(li.getId());
            MenuDaoImpl.getInstance().delete(li);
        }
        assertTrue(!list.isEmpty());
    }

}