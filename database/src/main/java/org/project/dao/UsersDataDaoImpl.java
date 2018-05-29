package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.UserDataDao;
import org.project.entity.UserData;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersDataDaoImpl extends BaseDao<Long, UserData> implements UserDataDao {

    private static final UsersDataDaoImpl INSTANCE = new UsersDataDaoImpl();

    public static UsersDataDaoImpl getInstance() {
        return INSTANCE;
    }
}
