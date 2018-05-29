package org.project.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.project.dao.Interface.TrademarkDao;
import org.project.entity.Trademark;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrademarkDaoImpl extends BaseDao<Long, Trademark> implements TrademarkDao {

    private static final TrademarkDaoImpl INSTANCE = new TrademarkDaoImpl();

    public static TrademarkDaoImpl getInstance() {
        return INSTANCE;
    }
}
