package org.project.dao;

import org.project.entity.LicenseEntity;

import java.util.List;


public class LicenseDao extends BaseDao {

    private static final LicenseDao INSTANCE = new LicenseDao();

    public void save(LicenseEntity license) {
        saveBase(license);
    }

    public void update(LicenseEntity license) {
        updateBase(license);
    }

    public LicenseEntity getById(Long id) {
        return getByIdBase(new LicenseEntity(), id);
    }

    public void removeById(Long id) {
        removeByIdBase(new LicenseEntity(), id);
    }

    public List<LicenseEntity> getAll() {
        return getAllBase(new LicenseEntity());
    }

    public static LicenseDao getInstance() {
        return INSTANCE;
    }
}
