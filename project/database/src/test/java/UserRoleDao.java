import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.LicenseEntity;
import org.project.entity.RoleEntity;
import org.project.entity.UserRoleEntity;
import org.project.entity.UsersEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UserRoleDao {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserRoleEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            Serializable userId = session.save(user);
            RoleEntity role = new RoleEntity();
            role.setRole("test");
            Serializable roleId = session.save(role);
            UsersEntity usersEntity = session.find(UsersEntity.class, userId);
            RoleEntity roleEntity = session.find(RoleEntity.class, roleId);
            UserRoleEntity userRoleEntity = new UserRoleEntity(usersEntity, roleEntity);
            session.save(userRoleEntity);
            Serializable serializable = session.save(userRoleEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {

        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            Serializable userId = session.save(user);
            RoleEntity role = new RoleEntity();
            role.setRole("test");
            Serializable roleId = session.save(role);
            UsersEntity usersEntity = session.find(UsersEntity.class, userId);
            RoleEntity roleEntity = session.find(RoleEntity.class, roleId);
            UserRoleEntity userRoleEntity = new UserRoleEntity(usersEntity, roleEntity);
            Serializable userRole = session.save(userRoleEntity);
            assertNotNull("Id is null", userRoleEntity);
            UserRoleEntity userRoleOut = session.find(UserRoleEntity.class, userRole);
            assertNotNull("Entity is null!", userRoleOut);
        }
    }
}
