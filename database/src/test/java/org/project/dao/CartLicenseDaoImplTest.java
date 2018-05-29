package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.CartLicense;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertNotEquals;

public class CartLicenseDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from CartLicense ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        CartLicense list = new CartLicense();
        list.setName("Save");
        list.setTestToo("TestToo");
        Serializable lis = CartLicenseDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<CartLicense> list = CartLicenseDaoImpl.getInstance().findAll();
        for (CartLicense li : list) {
            CartLicense ln = CartLicenseDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<CartLicense> list = CartLicenseDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<CartLicense> list = CartLicenseDaoImpl.getInstance().findAll();
        for (CartLicense li : list) {
            String old = li.getTestToo();
            li.setName("Update");
            li.setTestToo("Update");
            CartLicenseDaoImpl.getInstance().update(li);
            CartLicense news = CartLicenseDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news);
        }
        assertNotNull("Id is null", list);
    }
}