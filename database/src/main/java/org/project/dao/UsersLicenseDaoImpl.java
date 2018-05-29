package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.UsersLicenseDao;
import org.project.entity.UsersLicense;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersLicenseDaoImpl extends BaseDao<Long, UsersLicense> implements UsersLicenseDao {

    private static final UsersLicenseDaoImpl INSTANCE = new UsersLicenseDaoImpl();

    public static UsersLicenseDaoImpl getInstance() {
        return INSTANCE;
    }
}
