package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.CartLicense;
import org.project.entity.CartTrademark;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertNotEquals;

public class CartTrademarkDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from CartTrademark ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        CartTrademark list = new CartTrademark();
        list.setName("Save");
        list.setTestOne("TestOne");
        Serializable lis = CartTrademarkDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<CartTrademark> list = CartTrademarkDaoImpl.getInstance().findAll();
        for (CartTrademark li : list) {
            CartTrademark ln = CartTrademarkDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<CartTrademark> list = CartTrademarkDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<CartTrademark> list = CartTrademarkDaoImpl.getInstance().findAll();
        for (CartTrademark li : list) {
            String old = li.getTestOne();
            li.setName("Update");
            li.setTestOne("Update");
            CartTrademarkDaoImpl.getInstance().update(li);
            CartLicense news = CartLicenseDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news);
        }
        assertNotNull("Id is null", list);
    }
}