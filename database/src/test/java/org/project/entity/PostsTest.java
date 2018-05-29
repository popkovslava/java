package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

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

    @Test(priority = 1)
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            PostsCategory postCtegoryEntity = new PostsCategory();
            postCtegoryEntity.setTitle("test Post");
            Posts postsEntity = new Posts();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegory(session.find(PostsCategory.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
        }
    }


    @Test(priority = 2)
    public void checkFindEmployee() {

        try (Session session = FACTORY.openSession()) {
            PostsCategory postCtegoryEntity = new PostsCategory();
            postCtegoryEntity.setTitle("test Post");
            Posts postsEntity = new Posts();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegory(session.find(PostsCategory.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
            PostsCategory postCtegoryEntityOut = session.find(PostsCategory.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }

}