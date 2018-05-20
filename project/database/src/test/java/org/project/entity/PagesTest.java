package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;


public class PagesTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Pages ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Menu menuEntity = new Menu();
            menuEntity.setTitle("test Page");
            Serializable serializ = session.save(menuEntity);
            Pages pagesEntity = new Pages();
            pagesEntity.setTitle("test");
            pagesEntity.setMenu(session.find(Menu.class, serializ));
            Serializable serializable = session.save(pagesEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            Menu menuEntity = new Menu();
            menuEntity.setTitle("test Page");
            Serializable serializ = session.save(menuEntity);
            Pages pagesEntity = new Pages();
            pagesEntity.setTitle("test");
            pagesEntity.setMenu(session.find(Menu.class, serializ));
            Serializable serializable = session.save(pagesEntity);
            assertNotNull("Id is null", serializable);
            Pages pageOut = session.find(Pages.class, serializable);
            assertNotNull("Entity is null!", pageOut);
        }
    }

}