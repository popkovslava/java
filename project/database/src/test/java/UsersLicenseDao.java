import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UsersLicenseDao {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UsersLicenseEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            LicenseEntity license = new LicenseEntity();
            license.setTitle("test");
            UsersEntity usersEntity = session.find(UsersEntity.class, session.save(user));
            LicenseEntity licenseEntity = session.find(LicenseEntity.class, session.save(license));
            UsersLicenseEntity usersLicenseEntity = new UsersLicenseEntity(usersEntity, licenseEntity);
            Serializable serializable = session.save(usersLicenseEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            LicenseEntity license = new LicenseEntity();
            license.setTitle("test");
            UsersEntity usersEntity = session.find(UsersEntity.class, session.save(user));
            LicenseEntity licenseEntity = session.find(LicenseEntity.class, session.save(license));
            UsersLicenseEntity usersLicenseEntity = new UsersLicenseEntity(usersEntity, licenseEntity);
            Serializable serializable = session.save(usersLicenseEntity);
            assertNotNull("Id is null", serializable);
            UsersLicenseEntity OutUsersLicense = session.find(UsersLicenseEntity.class, serializable);
            assertNotNull("Entity is null!", OutUsersLicense);
        }
    }
}
