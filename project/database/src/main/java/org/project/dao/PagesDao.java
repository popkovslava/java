package org.project.dao;


import org.project.entity.PagesEntity;

import java.util.List;

public class PagesDao extends  BaseDao{

    private static final PagesDao INSTANCE =new PagesDao();

    public void save(PagesEntity pages) {
        saveBase(pages);
    }

    public void update(PagesEntity pages) {
        updateBase(pages);
    }

    public PagesEntity getById(Long id) {
        return getByIdBase(new PagesEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new PagesEntity(), id);
    }

    public List<PagesEntity> getAll() {
        return getAllBase(new PagesEntity());
    }

    public static PagesDao getInstance() {
        return INSTANCE;
    }
}
