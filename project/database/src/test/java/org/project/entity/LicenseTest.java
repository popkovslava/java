package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;


public class LicenseTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from License ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        License licenseEntity = new License();
        licenseEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable serializable = session.save(licenseEntity);
            assertNotNull("Id is null", serializable);
        }
    }


    @Test
    public void checkFindEmployee() {
        License licenseEntity = new License();
        licenseEntity.setTitle("test");
        try (Session session = FACTORY.openSession()) {
            Serializable serializable = session.save(licenseEntity);
            assertNotNull("Id is null", serializable);
            License licenseEntityOut = session.find(License.class, serializable);
            assertNotNull("Entity is null!", licenseEntityOut);
        }
    }


}