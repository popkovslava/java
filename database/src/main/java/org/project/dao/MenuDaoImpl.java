package org.project.dao;

import java.util.List;
import org.project.dao.Interface.MenuDao;
import org.project.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Long, Menu> implements MenuDao {

    public List<Menu> getMenu() {
        return sessionFactory.getCurrentSession().createQuery(
                "select m from Menu m left join" +
                        " Pages p on m.id=p.menu " +
                        "WHERE p.menu!=null"
        ).getResultList();
    }
}
