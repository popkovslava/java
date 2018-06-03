package org.project.dao;

import org.project.dao.Interface.UserDataDao;
import org.project.entity.UserData;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDataDaoImpl extends BaseDaoImpl<Long, UserData> implements UserDataDao {
}
