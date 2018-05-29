package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.UsersDao;
import org.project.entity.Users;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersDaoImpl extends BaseDao<Long, Users> implements UsersDao {

    private static final UsersDaoImpl INSTANCE = new UsersDaoImpl();

    public static UsersDaoImpl getInstance() {
        return INSTANCE;
    }
}
