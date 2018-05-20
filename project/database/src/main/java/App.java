import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.project.dao.MenuDao;
import org.project.entity.Menu;

public class App {
    public static void main(String[] args) {
       SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();
       Session session = FACTORY.openSession();
       session.beginTransaction();
       session.getTransaction().commit();
    }
}
