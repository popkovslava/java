package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;


public class MenuTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Menu ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {

        Menu menuEntity = new Menu();
        menuEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable employeeId = session.save(menuEntity);
            assertNotNull("Id is null", employeeId);
        }
    }

    @Test
    public void checkFindEmployee() {
        Menu menuEntity = new Menu();
        menuEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable menu = session.save(menuEntity);
            assertNotNull("Id is null", menu);
            Menu menuOut = session.find(Menu.class, menu);
            assertNotNull("Entity is null!", menuOut);
        }
    }

}