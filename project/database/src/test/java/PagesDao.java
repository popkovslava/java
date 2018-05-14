import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.MenuEntity;
import org.project.entity.PagesEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class PagesDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from PagesEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setTitle("test Page");
            Serializable serializ = session.save(menuEntity);
            PagesEntity pagesEntity = new PagesEntity();
            pagesEntity.setTitle("test");
            pagesEntity.setMenu(session.find(MenuEntity.class, serializ));
            Serializable serializable = session.save(pagesEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setTitle("test Page");
            Serializable serializ = session.save(menuEntity);
            PagesEntity pagesEntity = new PagesEntity();
            pagesEntity.setTitle("test");
            pagesEntity.setMenu(session.find(MenuEntity.class, serializ));
            Serializable serializable = session.save(pagesEntity);
            assertNotNull("Id is null", serializable);
            PagesEntity pageOut = session.find(PagesEntity.class, serializable);
            assertNotNull("Entity is null!", pageOut);
        }
    }

}
