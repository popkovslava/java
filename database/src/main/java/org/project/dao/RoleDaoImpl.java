package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.RoleDao;
import org.project.entity.Role;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDaoImpl extends BaseDao<Long, Role> implements RoleDao {

    private static final RoleDaoImpl INSTANCE = new RoleDaoImpl();

    public static RoleDaoImpl getInstance() {
        return INSTANCE;
    }
}
