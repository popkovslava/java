import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.MenuEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class MenuDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from MenuEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable employeeId = session.save(menuEntity);
            assertNotNull("Id is null", employeeId);
        }
    }

    @Test
    public void checkFindEmployee() {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable menu = session.save(menuEntity);
            assertNotNull("Id is null", menu);
            MenuEntity menuOut = session.find(MenuEntity.class, menu);
            assertNotNull("Entity is null!", menuOut);
        }
    }

}
