package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.UsersTrademarkDao;
import org.project.entity.UserTrademark;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersTrademarkDaoImpl extends BaseDao<Long, UserTrademark> implements UsersTrademarkDao {

    private static final UsersTrademarkDaoImpl INSTANCE = new UsersTrademarkDaoImpl();

    public static UsersTrademarkDaoImpl getInstance() {
        return INSTANCE;
    }

}
