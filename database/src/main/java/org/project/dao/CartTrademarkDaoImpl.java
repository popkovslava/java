package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.CartTrademarkDao;
import org.project.entity.CartTrademark;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartTrademarkDaoImpl extends BaseDao<Long, CartTrademark> implements CartTrademarkDao {

    private static final CartTrademarkDaoImpl INSTANCE = new CartTrademarkDaoImpl();

    public static CartTrademarkDaoImpl getInstance() {
        return INSTANCE;
    }
}
