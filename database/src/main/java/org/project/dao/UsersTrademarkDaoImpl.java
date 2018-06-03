package org.project.dao;

import org.project.dao.Interface.UsersTrademarkDao;
import org.project.entity.UserTrademark;
import org.springframework.stereotype.Repository;

@Repository
public class UsersTrademarkDaoImpl extends BaseDaoImpl<Long, UserTrademark> implements UsersTrademarkDao {
}
