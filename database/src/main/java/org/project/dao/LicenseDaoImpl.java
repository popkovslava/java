package org.project.dao;

import org.project.dao.Interface.LicenseDao;
import org.project.entity.License;
import org.springframework.stereotype.Repository;

@Repository
public class LicenseDaoImpl extends BaseDaoImpl<Long, License> implements LicenseDao {
}
