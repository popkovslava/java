package org.project.dao;

import org.project.dao.Interface.CartDao;
import org.project.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public class CatrDaoImpl extends BaseDaoImpl<Long, Cart> implements CartDao {
}