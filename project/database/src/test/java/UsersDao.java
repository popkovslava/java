import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.UsersEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UsersDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UsersEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable employeeId = session.save(usersEntity);
            assertNotNull("Id is null", employeeId);
        }
    }

    @Test
    public void checkFindEmployee() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable user = session.save(usersEntity);
            assertNotNull("Id is null", user);
            UsersEntity userOut = session.find(UsersEntity.class, user);
            assertNotNull("Entity is null!", userOut);
        }
    }
}
