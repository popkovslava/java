package org.project.dao;

import org.project.entity.Role;

import java.util.List;

public class RoleDao extends BaseDao {

    private static final RoleDao INSTANCE = new RoleDao();

    public void save(Role menu) {
        saveBase(menu);
    }

    public void update(Role menu) {
        updateBase(menu);
    }

    public Role getById(Long id) {
        return getByIdBase(new Role(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new Role(), id);
    }

    public List<Role> getAll() {
        return getAllBase(new Role());
    }

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
