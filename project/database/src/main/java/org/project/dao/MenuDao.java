package org.project.dao;

import org.project.entity.MenuEntity;

import java.util.List;


public class MenuDao extends BaseDao {

    private static final MenuDao INSTANCE = new MenuDao();

    public void save(MenuEntity menu) {
        saveBase(menu);
    }

    public void update(MenuEntity menu) {
        updateBase(menu);
    }

    public MenuEntity getById(Long id) {
        return getByIdBase(new MenuEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new MenuEntity(), id);
    }

    public List<MenuEntity> getAll() {
        return getAllBase(new MenuEntity());
    }

    public static MenuDao getInstance() {
        return INSTANCE;
    }

}
