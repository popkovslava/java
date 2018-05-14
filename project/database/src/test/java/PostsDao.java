import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.PostCtegoryEntity;
import org.project.entity.PostsEntity;
import org.project.entity.RoleEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class PostsDao {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from PostsEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            PostCtegoryEntity postCtegoryEntity = new PostCtegoryEntity();
            postCtegoryEntity.setTitle("test Post");
            PostsEntity postsEntity = new PostsEntity();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegoryEntity(session.find(PostCtegoryEntity.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
        }
    }


    @Test
    public void checkFindEmployee() {

        try (Session session = FACTORY.openSession()) {
            PostCtegoryEntity postCtegoryEntity = new PostCtegoryEntity();
            postCtegoryEntity.setTitle("test Post");
            PostsEntity postsEntity = new PostsEntity();
            Serializable postCategory = session.save(postCtegoryEntity);
            postsEntity.setTitle("test");
            postsEntity.setText("Text title");
            postsEntity.setPostCtegoryEntity(session.find(PostCtegoryEntity.class, postCategory));
            session.save(postsEntity);
            Serializable serializable = session.save(postsEntity);
            assertNotNull("Id is null", serializable);
            PostCtegoryEntity postCtegoryEntityOut = session.find(PostCtegoryEntity.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }
}
