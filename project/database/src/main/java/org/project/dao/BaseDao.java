package org.project.dao;

import java.io.Serializable;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.project.dao.Interface.BaseDaoInterface;
import org.project.entity.Base;
import org.project.manager.SessionFactoryManager;
import java.lang.reflect.ParameterizedType;

public class BaseDao<PK extends Serializable, T extends Base<PK>> implements BaseDaoInterface<PK, T> {

    protected static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    private Class<T> clazz;

    public BaseDao() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK save(T object) {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            Serializable id = session.save(object);
            session.getTransaction().commit();
            return (PK) id;
        }
    }

    @Override
    public T findById(PK id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.find(clazz, id);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = cb.createQuery(clazz);
            Root<T> root = criteria.from(clazz);
            return session.createQuery(criteria).list();
        }
    }

    @Override
    public void update(T object) {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T object) {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }
    }
}
