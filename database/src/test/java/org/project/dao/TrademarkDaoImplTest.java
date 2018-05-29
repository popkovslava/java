package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Trademark;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class TrademarkDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Trademark ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Trademark list = new Trademark();
        list.setTitle("Save");
        Serializable lis = TrademarkDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Trademark> list = TrademarkDaoImpl.getInstance().findAll();
        for (Trademark li : list) {
            Trademark ln = TrademarkDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Trademark> list = TrademarkDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Trademark> list = TrademarkDaoImpl.getInstance().findAll();
        for (Trademark li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Update");
            TrademarkDaoImpl.getInstance().update(li);
            Trademark news = TrademarkDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Trademark> list = TrademarkDaoImpl.getInstance().findAll();
        for (Trademark li : list) {
            TrademarkDaoImpl.getInstance().delete(TrademarkDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}