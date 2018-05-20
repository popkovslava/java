package org.project.dao;

import org.project.entity.Menu;

import java.util.List;

public class MenuDao extends BaseDao {

    private static final MenuDao INSTANCE = new MenuDao();

    public void save(Menu menu) {
        saveBase(menu);
    }

    public void update(Menu menu) {
        updateBase(menu);
    }

    public Menu getById(Long id) {
        return getByIdBase(new Menu(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new Menu(), id);
    }

    public List<Menu> getAll() {
        return getAllBase(new Menu());
    }

    public static MenuDao getInstance() {
        return INSTANCE;
    }

}
