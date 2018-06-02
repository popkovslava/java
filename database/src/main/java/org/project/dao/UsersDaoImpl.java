package org.project.dao;

import org.project.dao.Interface.UsersDao;
import org.project.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl extends BaseDaoImpl<Long, Users> implements UsersDao {
}
