package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.License;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class LicenseDaoImplTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from License ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        License list = new License();
        list.setTitle("Save");
        Serializable lis = LicenseDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<License> list = LicenseDaoImpl.getInstance().findAll();
        for (License li : list) {
            License ln = LicenseDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<License> list = LicenseDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<License> list = LicenseDaoImpl.getInstance().findAll();
        for (License li : list) {
            String old = li.getTitle();
            li.setId(li.getId());
            li.setTitle("Update");
            li.setArticle("Update");
            LicenseDaoImpl.getInstance().update(li);
            License news = LicenseDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getTitle());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<License> list = LicenseDaoImpl.getInstance().findAll();
        for (License li : list) {
            LicenseDaoImpl.getInstance().delete(LicenseDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}