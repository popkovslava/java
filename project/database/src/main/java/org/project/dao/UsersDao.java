package org.project.dao;

import org.project.dao.Interface.UsersDaoInterface;
import org.project.entity.Users;

public class UsersDao extends BaseDao<Long, Users> implements UsersDaoInterface {
    private static final UsersDao INSTANCE = new UsersDao();
    public static UsersDao getInstance() {
        return INSTANCE;
    }
}
