package org.project.dao;

public class UserRoleDao {
    private static final UserRoleDao INSTANCE = new UserRoleDao();

    public static UserRoleDao getInstance() {
        return INSTANCE;
    }
}
