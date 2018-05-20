package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;


public class UsersLicenseTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UsersLicense ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Users user = new Users();
            user.setName("test");
            License license = new License();
            license.setTitle("test");
            Users usersEntity = session.find(Users.class, session.save(user));
            License licenseEntity = session.find(License.class, session.save(license));
            UsersLicense usersLicenseEntity = new UsersLicense(usersEntity, licenseEntity);
            Serializable serializable = session.save(usersLicenseEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            Users user = new Users();
            user.setName("test");
            License license = new License();
            license.setTitle("test");
            Users usersEntity = session.find(Users.class, session.save(user));
            License licenseEntity = session.find(License.class, session.save(license));
            UsersLicense usersLicenseEntity = new UsersLicense(usersEntity, licenseEntity);
            Serializable serializable = session.save(usersLicenseEntity);
            assertNotNull("Id is null", serializable);
            UsersLicense OutUsersLicense = session.find(UsersLicense.class, serializable);
            assertNotNull("Entity is null!", OutUsersLicense);
        }
    }

}