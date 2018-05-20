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

public class PostsTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Posts ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            PostCtegory postCtegoryEntity = new PostCtegory();
            postCtegoryEntity.setTitle("test Post");
            Posts postsEntity = new Posts();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegory(session.find(PostCtegory.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
        }
    }


    @Test
    public void checkFindEmployee() {

        try (Session session = FACTORY.openSession()) {
            PostCtegory postCtegoryEntity = new PostCtegory();
            postCtegoryEntity.setTitle("test Post");
            Posts postsEntity = new Posts();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegory(session.find(PostCtegory.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
            PostCtegory postCtegoryEntityOut = session.find(PostCtegory.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }

}