import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.RoleEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class RoleDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from RoleEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable employeeId = session.save(roleEntity);
            assertNotNull("Id is null", employeeId);
        }
    }

    @Test
    public void checkFindEmployee() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole("test");
        try (Session session = FACTORY.openSession()) {
            Serializable role = session.save(roleEntity);
            assertNotNull("Id is null", role);
            RoleEntity roleOut = session.find(RoleEntity.class, role);
            assertNotNull("Entity is null!", roleOut);
        }
    }
}
