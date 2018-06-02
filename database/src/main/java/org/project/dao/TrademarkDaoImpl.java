package org.project.dao;

import org.project.dao.Interface.TrademarkDao;
import org.project.entity.Trademark;
import org.springframework.stereotype.Repository;

@Repository
public class TrademarkDaoImpl extends BaseDaoImpl<Long, Trademark> implements TrademarkDao {
}
