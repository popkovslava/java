package org.project.dao;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.project.dao.Interface.PagesDao;
import org.project.entity.Pages;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagesDaoImpl extends BaseDao<Long, Pages> implements PagesDao {

    private static final PagesDaoImpl INSTANCE = new PagesDaoImpl();

    public List<Pages> getPageBySlug(String slug) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery(
                    "select p from Pages p left join" +
                            " Menu m on p.menu=m.id " +
                            "WHERE p.menu!=null AND p.slug=:slug");
            return query.setParameter("slug", slug).list();
        }
    }

    public List<Pages> getPageWithMenu() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery(
                    "select p from Pages p left join" +
                            " Menu m on p.menu=m.id " +
                            "WHERE p.menu!=null");
            return query.list();
        }
    }

    public static PagesDaoImpl getInstance() {
        return INSTANCE;
    }
}
