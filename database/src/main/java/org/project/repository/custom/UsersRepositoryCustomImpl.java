package org.project.repository.custom;

import java.util.List;
import org.hibernate.SessionFactory;
import org.project.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryCustomImpl implements UsersRepositoryCustom {

    private SessionFactory sessionFactory;

    @Autowired
    UsersRepositoryCustomImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Users> findByName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("select u from Users u WHERE u.username=:username")
                .setParameter("username", username)
                .getResultList();
    }
}