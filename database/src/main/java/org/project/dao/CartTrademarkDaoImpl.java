package org.project.dao;

import org.project.dao.Interface.CartTrademarkDao;
import org.project.entity.CartTrademark;
import org.springframework.stereotype.Repository;

@Repository
public class CartTrademarkDaoImpl extends BaseDaoImpl<Long, CartTrademark> implements CartTrademarkDao {
}
