package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.CartDao;
import org.project.entity.Cart;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CatrDaoImpl extends BaseDao<Long, Cart> implements CartDao {

    private static final CatrDaoImpl INSTANCE = new CatrDaoImpl();

    public static CatrDaoImpl getInstance() {
        return INSTANCE;
    }

}