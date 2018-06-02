package org.project.dao;

import org.project.dao.Interface.UserRoleDao;
import org.project.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<Long, UserRole> implements UserRoleDao {
}


