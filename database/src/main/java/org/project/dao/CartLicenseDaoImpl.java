package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.CartLicenseDao;
import org.project.entity.CartLicense;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartLicenseDaoImpl extends BaseDao<Long, CartLicense> implements CartLicenseDao {

    private static final CartLicenseDaoImpl INSTANCE = new CartLicenseDaoImpl();

    public static CartLicenseDaoImpl getInstance() {
        return INSTANCE;
    }

}
