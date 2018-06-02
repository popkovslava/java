package org.project.dao;

import org.project.dao.Interface.RoleDao;
import org.project.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Long, Role> implements RoleDao {
}
