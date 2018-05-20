package org.project.dao;

import org.project.entity.Users;

import java.util.List;

public class UsersDao extends BaseDao {

    private static final UsersDao INSTANCE = new UsersDao();

    public void save(Users users) {
        saveBase(users);
    }

    public void update(Users users) {
        updateBase(users);
    }

    public Users getById(Long id) {
        return getByIdBase(new Users(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new Users(), id);
    }

    public List<Users> getAll() {
        return getAllBase(new Users());
    }

    public static UsersDao getInstance() {
        return INSTANCE;
    }

}
