package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

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
            session.createQuery("delete from PostsCategory ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test(priority = 1)
    public void checkSaveEntity() {
        Pages page = new Pages();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostsCategory postCtegoryEntity = new PostsCategory();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPages(session.find(Pages.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test(priority = 2)
    public void checkFindEmployee() {
        Pages page = new Pages();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostsCategory postCtegoryEntity = new PostsCategory();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPages(session.find(Pages.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
            PostsCategory postCtegoryEntityOut = session.find(PostsCategory.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }

}