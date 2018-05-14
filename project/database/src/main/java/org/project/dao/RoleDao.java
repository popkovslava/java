package org.project.dao;

import org.project.entity.RoleEntity;

import java.util.List;

public class RoleDao extends BaseDao {

    private static final RoleDao INSTANCE =new RoleDao();

    public void save(RoleEntity menu) {
        saveBase(menu);
    }

    public void update(RoleEntity menu) {
        updateBase(menu);
    }

    public RoleEntity getById(Long id) {
        return getByIdBase(new RoleEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new RoleEntity(), id);
    }

    public List<RoleEntity> getAll() {
        return getAllBase(new RoleEntity());
    }

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
