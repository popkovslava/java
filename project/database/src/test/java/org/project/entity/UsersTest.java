package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;


public class UsersTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Users ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        Users usersEntity = new Users();
        usersEntity.setName("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable serializable = session.save(usersEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        Users usersEntity = new Users();
        usersEntity.setName("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable user = session.save(usersEntity);
            assertNotNull("Id is null", user);
            Users userOut = session.find(Users.class, user);
            assertNotNull("Entity is null!", userOut);
        }
    }

}