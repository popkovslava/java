package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.UserRoleDao;
import org.project.entity.UserRole;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRoleDaoImpl extends BaseDao<Long, UserRole> implements UserRoleDao {

    private static final UserRoleDaoImpl INSTANCE = new UserRoleDaoImpl();

    public static UserRoleDaoImpl getInstance() {
        return INSTANCE;
    }
}


