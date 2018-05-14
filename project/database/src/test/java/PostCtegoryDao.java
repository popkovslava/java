import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.PagesEntity;
import org.project.entity.PostCtegoryEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class PostCtegoryDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from PostCtegoryEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        PagesEntity page = new PagesEntity();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostCtegoryEntity postCtegoryEntity = new PostCtegoryEntity();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPagesEntity(session.find(PagesEntity.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        PagesEntity page = new PagesEntity();
        page.setTitle("Test Category");
        try (Session session = FACTORY.openSession()) {
            Serializable pageId = session.save(page);
            PostCtegoryEntity postCtegoryEntity = new PostCtegoryEntity();
            postCtegoryEntity.setTitle("Test");
            postCtegoryEntity.setText("Text Test");
            postCtegoryEntity.setPagesEntity(session.find(PagesEntity.class, pageId));
            Serializable serializable = session.save(postCtegoryEntity);
            assertNotNull("Id is null", serializable);
            PostCtegoryEntity postCtegoryEntityOut = session.find(PostCtegoryEntity.class, serializable);
            assertNotNull("Entity is null!", postCtegoryEntityOut);
        }
    }
}
