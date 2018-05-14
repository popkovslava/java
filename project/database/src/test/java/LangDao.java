import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.LangEntity;
import org.project.entity.LicenseEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class LangDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from LangEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            LangEntity langEntity = new LangEntity();
            langEntity.setLn("ln");
            langEntity.setLn_title("англйскй");
            session.save(langEntity);
            Serializable serializable = session.save(langEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            LangEntity langEntity = new LangEntity();
            langEntity.setLn("ln");
            langEntity.setLn_title("англйскй");
            session.save(langEntity);
            Serializable serializable = session.save(langEntity);
            assertNotNull("Id is null", serializable);
            LicenseEntity licenseEntityOut = session.find(LicenseEntity.class, serializable);
            assertNotNull("Entity is null!", licenseEntityOut);
        }
    }

}
