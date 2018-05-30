package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.project.entity.Base;
import org.project.manager.SessionFactoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

public class BaseDao<PK extends Serializable, T extends Base<PK>> implements org.project.dao.Interface.BaseDao<PK, T> {

    protected static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[1];
    }

    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        return (PK) sessionFactory.getCurrentSession().save(entity);
    }


    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public T findOne(PK id) {
        return sessionFactory.getCurrentSession().find(clazz, id);
    }

    @Override
    public void removeAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Lang ");
            session.getTransaction().commit();
        }
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(String.format("select e from %s e", clazz.getSimpleName()), clazz)
                .list();
    }
}
