package org.project.dao;

import java.util.List;
import org.project.dao.Interface.PagesDao;
import org.project.entity.Pages;
import org.springframework.stereotype.Repository;

@Repository
public class PagesDaoImpl extends BaseDaoImpl<Long, Pages> implements PagesDao {

    public List<Pages> getPageBySlug(String slug) {
        return sessionFactory.getCurrentSession().createQuery(
                "select p from Pages p left join" +
                        " Menu m on p.menu=m.id " +
                        "WHERE p.menu!=null AND p.slug=:slug")
                .setParameter("slug", slug).getResultList();
    }

    public List<Pages> getPage() {
        return sessionFactory.getCurrentSession().createQuery(
                "select p from Pages p left join" +
                        " Menu m on p.menu=m.id " +
                        "WHERE p.menu!=null").getResultList();
    }

}
