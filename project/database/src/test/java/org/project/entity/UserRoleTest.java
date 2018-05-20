package org.project.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;
import static org.junit.Assert.assertNotNull;


public class UserRoleTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }


    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserRole").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Users user = new Users();
            user.setName("test");
            Role role = new Role();
            role.setRole("test");
            Users usersEntity = session.find(Users.class,  session.save(user));
            Role roleEntity = session.find(Role.class,    session.save(role));
            UserRole userRoleEntity = new UserRole(usersEntity, roleEntity);
            session.save(userRoleEntity);
            Serializable serializable = session.save(userRoleEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            UserRole userRoleOut = session.find(UserRole.class, 1L);
            assertNotNull("Entity is null!", userRoleOut);
        }
    }

}