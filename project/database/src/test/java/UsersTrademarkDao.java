import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UsersTrademarkDao {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserTrademarkEntity").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            TrademarkEntity trademark = new TrademarkEntity();
            trademark.setTitle("test");
            UsersEntity usersEntity = session.find(UsersEntity.class, session.save(user));
            TrademarkEntity trademarkEntity = session.find(TrademarkEntity.class, session.save(trademark));
            UserTrademarkEntity trademarkEntity1 = new UserTrademarkEntity(usersEntity, trademarkEntity);
            Serializable serializable = session.save(trademarkEntity1);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        try (Session session = FACTORY.openSession()) {
            UsersEntity user = new UsersEntity();
            user.setName("test");
            TrademarkEntity trademark = new TrademarkEntity();
            trademark.setTitle("test");
            UsersEntity usersEntity = session.find(UsersEntity.class, session.save(user));
            TrademarkEntity trademarkEntity = session.find(TrademarkEntity.class, session.save(trademark));
            UserTrademarkEntity trademarkEntity1 = new UserTrademarkEntity(usersEntity, trademarkEntity);
            Serializable serializable = session.save(trademarkEntity1);
            assertNotNull("Id is null", serializable);
            UsersLicenseEntity OutUsersLicense = session.find(UsersLicenseEntity.class, serializable);
            assertNotNull("Entity is null!", OutUsersLicense);
        }

    }

}