package org.project.dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.project.entity.Base;

import java.util.*;

public abstract class BaseDao {

    protected static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    protected static <T extends Base<?>> void saveBase(T... object) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            Arrays.asList(object).forEach(it -> {
                session.save(it);
            });
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    protected static <T extends Base<?>> void updateBase(T object) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    protected static <T extends Base<?>> T getByIdBase(T object, Long id) {
        Session session = FACTORY.openSession();
        T result = null;
        try {
            session.beginTransaction();
            result = (T) session.load(object.getClass(), id);
            Hibernate.initialize(result);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    protected static <T extends Base<?>> List<T> getAllBase(T object) {
        Session session = FACTORY.openSession();
        List<T> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createQuery("from Menu").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

    protected static <T extends Base<?>> void removeByIdBase(T object, Long id) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            session.remove(session.find(object.getClass(), id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


}
