package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.CartLicenseDao;
import org.project.entity.CartLicense;
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
public class CartLicenseDaoImplTest {
    @Autowired
    private CartLicenseDao cartLicenseDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", cartLicenseDao);
    }

    @Test
    public void checkSaveEntity() {
        Long id = cartLicenseDao.save(new CartLicense("Test", "Test"));
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<CartLicense> cartTrademarks = cartLicenseDao.findAll();
        assertThat("Employees collection is not empty", cartTrademarks, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        CartLicense cartLicense = new CartLicense("Test", "Test");
        Long id = cartLicenseDao.save(cartLicense);
        CartLicense cartLicense1 = cartLicenseDao.findOne(id);
        assertNotNull("FindById does not work", cartLicense1);
    }
}