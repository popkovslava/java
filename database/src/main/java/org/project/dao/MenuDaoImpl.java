package org.project.dao;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.project.dao.Interface.MenuDao;
import org.project.entity.Menu;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuDaoImpl extends BaseDao<Long, Menu> implements MenuDao {

    private static final MenuDaoImpl INSTANCE = new MenuDaoImpl();

    public List<Menu> getMenu() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery(
                    "select m from Menu m left join" +
                            " Pages p on m.id=p.menu " +
                            "WHERE p.menu!=null");
            return query.list();
        }

    }

    public static MenuDaoImpl getInstance() {
        return INSTANCE;
    }
}
