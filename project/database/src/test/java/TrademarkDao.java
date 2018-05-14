import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.project.entity.TrademarkEntity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class TrademarkDao {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from TrademarkEntity ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        TrademarkEntity trademarkEntity = new TrademarkEntity();
        trademarkEntity.setTitle("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable serializable = session.save(trademarkEntity);
            assertNotNull("Id is null", serializable);
        }
    }

    @Test
    public void checkFindEmployee() {
        TrademarkEntity trademarkEntity = new TrademarkEntity();
        trademarkEntity.setTitle("Test");
        try (Session session = FACTORY.openSession()) {
            Serializable trademark = session.save(trademarkEntity);
            assertNotNull("Id is null", trademark);
            TrademarkEntity trademarkOut = session.find(TrademarkEntity.class, trademark);
            assertNotNull("Entity is null!", trademarkOut);
        }
    }
}
