package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.RoleDaoInterface;
import org.project.entity.Role;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDao extends BaseDao<Long, Role> implements RoleDaoInterface {
    private static final RoleDao INSTANCE = new RoleDao();
    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
