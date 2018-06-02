package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.LicenseDao;
import org.project.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class LicenseDaoImplTest {

    @Autowired
    private LicenseDao licenseDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", licenseDao);
    }

    @Test
    public void checkSaveEntity() {
        License license = new License();
        license.setTitle("test");
        Long id = licenseDao.save(license);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<License> licenses = licenseDao.findAll();
        assertThat("Employees collection is not empty", licenses, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        License license = new License();
        license.setTitle("test");
        Long id = licenseDao.save(license);
        License license1 = licenseDao.findOne(id);
        assertNotNull("FindById does not work", license1);
    }
}