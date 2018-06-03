package org.project.dao;

import org.project.dao.Interface.UsersLicenseDao;
import org.project.entity.UsersLicense;
import org.springframework.stereotype.Repository;

@Repository
public class UsersLicenseDaoImpl extends BaseDaoImpl<Long, UsersLicense> implements UsersLicenseDao {
}
