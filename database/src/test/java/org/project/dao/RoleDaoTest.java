package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.project.entity.Role;
import org.project.manager.SessionFactoryManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class RoleDaoTest {

    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @AfterClass
    public static void after() {
        SESSION_FACTORY.close();
    }

    @Before
    public void cleanEntity() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Posts ");
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Role list = new Role();
        list.setRole("Save");
        Serializable lis = RoleDaoImpl.getInstance().save(list);
        assertNotNull("Id is null", lis);
    }

    @Test(priority = 2)
    public void checkFindById() {
        List<Role> list = RoleDaoImpl.getInstance().findAll();
        for (Role li : list) {
            Role ln = RoleDaoImpl.getInstance().findById(li.getId());
            assertNotNull("Id is null", ln);
        }
    }

    @Test(priority = 3)
    public void findAll() {
        List<Role> list = RoleDaoImpl.getInstance().findAll();
        assertNotNull("Id is null", list);
    }

    @Test(priority = 4)
    public void update() {
        List<Role> list = RoleDaoImpl.getInstance().findAll();
        for (Role li : list) {
            String old = li.getRole();
            li.setId(li.getId());
            li.setRole("Upadte");
            RoleDaoImpl.getInstance().update(li);
            Role news = RoleDaoImpl.getInstance().findById(li.getId());
            assertNotEquals(old, news.getRole());
            assertNotNull("Id is null", news);
        }
    }

    @Test(priority = 5)
    public void delete() {
        List<Role> list = RoleDaoImpl.getInstance().findAll();
        for (Role li : list) {
            RoleDaoImpl.getInstance().delete(RoleDaoImpl.getInstance().findById(li.getId()));
        }
        assertTrue(!list.isEmpty());
    }

}