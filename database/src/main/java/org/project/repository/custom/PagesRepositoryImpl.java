package org.project.repository.custom;

import org.springframework.stereotype.Repository;

@Repository
public class PagesRepositoryImpl {

//    public List<Pages> getPageBySlug(String slug) {
//        return sessionFactory.getCurrentSession().createQuery(
//                "select p from Pages p left join" +
//                        " Menu m on p.menu=m.id " +
//                        "WHERE p.menu!=null AND p.slug=:slug")
//                .setParameter("slug", slug).getResultList();
//    }
//
//    public List<Pages> getPage() {
//        return sessionFactory.getCurrentSession().createQuery(
//                "select p from Pages p left join" +
//                        " Menu m on p.menu=m.id " +
//                        "WHERE p.menu!=null").getResultList();
//    }
}
