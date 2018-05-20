package org.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.Serializable;
import static org.junit.Assert.assertNotNull;


public class LnagPagesTest{

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from LnagPages ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            Lang lang = new Lang();
            lang.setLn("test langPage");
            Pages page = new Pages();
            page.setTitle("test langPage");
            LnagPages lnagPagesEntity = new LnagPages(session.find(Lang.class, session.save(lang)),
                    session.find(Pages.class, session.save(page)));
            session.save(lnagPagesEntity);
            Serializable serializable = session.save(lnagPagesEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {

        try (Session session = FACTORY.openSession()) {
            Users user = new Users();
            user.setName("test");
            Serializable userId = session.save(user);
            Role role = new Role();
            role.setRole("test");
            Serializable roleId = session.save(role);
            UserRole userRoleEntity = new UserRole( session.find(Users.class, userId),
                    session.find(Role.class, roleId));
            Serializable userRole = session.save(userRoleEntity);
            assertNotNull("Id is null", userRoleEntity);
            UserRole userRoleOut = session.find(UserRole.class, userRole);
            assertNotNull("Entity is null!", userRoleOut);
        }
    }


}