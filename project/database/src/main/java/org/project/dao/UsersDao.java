package org.project.dao;

import org.project.entity.UsersEntity;

import java.util.List;

public class UsersDao extends BaseDao {

    private static final UsersDao INSTANCE = new UsersDao();

    public void save(UsersEntity users) {
        saveBase(users);
    }

    public void update(UsersEntity users) {
        updateBase(users);
    }

    public UsersEntity getById(Long id) {
        return getByIdBase(new UsersEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new UsersEntity(), id);
    }

    public List<UsersEntity> getAll() {
        return getAllBase(new UsersEntity());
    }

    public static UsersDao getInstance() {
        return INSTANCE;
    }

}
