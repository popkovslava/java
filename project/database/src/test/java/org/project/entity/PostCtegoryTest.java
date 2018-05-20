package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.*;

public class PostCtegoryTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from PostCtegory ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Pages page = new Pages();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostCtegory postCtegoryEntity = new PostCtegory();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPages(session.find(Pages.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        Pages page = new Pages();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostCtegory postCtegoryEntity = new PostCtegory();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPages(session.find(Pages.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
            PostCtegory postCtegoryEntityOut = session.find(PostCtegory.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }

}