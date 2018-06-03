package org.project.dao;

import org.project.dao.Interface.CartLicenseDao;
import org.project.entity.CartLicense;
import org.springframework.stereotype.Repository;

@Repository
public class CartLicenseDaoImpl extends BaseDaoImpl<Long, CartLicense> implements CartLicenseDao {

}
