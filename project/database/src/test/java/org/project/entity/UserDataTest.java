package org.project.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;
import static org.junit.Assert.assertNotNull;

public class UserDataTest{

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserData").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Users users= new  Users();
             users.setName("Test UserData");
             session.save(users);
             UserData userData= new  UserData();
            userData.setEmail("test@mail.com");
            userData.setPhone("+36767998");
            userData.setId(1l);
            Serializable serializable = session.save(userData);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            Users users= new  Users();
            users.setName("Test UserData");
            session.save(users);
            UserData userDataOut = session.find(UserData.class,session.find(Users.class,users));
            assertNotNull("Entity is null!",  userDataOut);
        }
    }

}