package org.project.dao.Interface;

import java.io.Serializable;

import java.util.List;
import org.project.entity.Base;


public interface BaseDaoInterface<PK extends Serializable, T extends Base<PK>> {

    PK save(T object);

    List<T> findAll();

    T findById(PK id);

    void update(T object);

    void delete(T object);

}
