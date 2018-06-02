package org.project.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.project.dao.Interface.BaseDao;
import org.project.entity.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

public class BaseDaoImpl<PK extends Serializable, T extends Base<PK>> implements BaseDao<PK, T> {

    @Autowired
    protected SessionFactory sessionFactory;


    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDaoImpl.class)[1];
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

    public List<T> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(String.format("select e from %s e", clazz.getSimpleName()), clazz)
                .list();
    }
}
