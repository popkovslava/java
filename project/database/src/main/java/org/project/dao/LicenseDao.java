package org.project.dao;

import org.project.entity.License;

import java.util.List;


public class LicenseDao extends BaseDao {

    private static final LicenseDao INSTANCE = new LicenseDao();

    public void save(License license) {
        saveBase(license);
    }

    public void update(License license) {
        updateBase(license);
    }

    public License getById(Long id) {
        return getByIdBase(new License(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new License(), id);
    }

    public List<License> getAll() {
        return getAllBase(new License());
    }

    public static LicenseDao getInstance() {
        return INSTANCE;
    }
}
