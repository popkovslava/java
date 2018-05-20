package org.project.dao;

import org.project.entity.Pages;

import java.util.List;

public class PagesDao extends BaseDao {

    private static final PagesDao INSTANCE = new PagesDao();

    public void save(Pages pages) {
        saveBase(pages);
    }

    public void update(Pages pages) {
        updateBase(pages);
    }

    public Pages getById(Long id) {
        return getByIdBase(new Pages(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new Pages(), id);
    }

    public List<Pages> getAll() {
        return getAllBase(new Pages());
    }

    public static PagesDao getInstance() {
        return INSTANCE;
    }
}
