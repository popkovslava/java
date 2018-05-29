package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.LicenseDao;
import org.project.entity.License;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LicenseDaoImpl extends BaseDao<Long, License> implements LicenseDao {

    private static final LicenseDaoImpl INSTANCE = new LicenseDaoImpl();

    public static LicenseDaoImpl getInstance() {
        return INSTANCE;
    }
}
