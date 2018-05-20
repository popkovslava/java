package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.*;

public class RoleTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Role ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Role roleEntity = new Role();
        roleEntity.setRole("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable employeeId = session.save(roleEntity);
            assertNotNull("Id is null", employeeId);
        }
    }

    @Test
    public void checkFindEmployee() {
        Role roleEntity = new Role();
        roleEntity.setRole("test");
        try (Session session = FACTORY.openSession()) {
            Serializable role = session.save(roleEntity);
            assertNotNull("Id is null", role);
            Role roleOut = session.find(Role.class, role);
            assertNotNull("Entity is null!", roleOut);
        }
    }

}