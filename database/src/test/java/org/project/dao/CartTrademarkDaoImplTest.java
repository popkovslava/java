package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.CartTrademarkDao;
import org.project.entity.CartTrademark;
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
public class CartTrademarkDaoImplTest {

    @Autowired
    private CartTrademarkDao cartTrademarkDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", cartTrademarkDao);
    }

    @Test
    public void checkSaveEntity() {
        Long id = cartTrademarkDao.save(new CartTrademark("Test", "Test"));
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<CartTrademark> cartTrademarks = cartTrademarkDao.findAll();
        assertThat("Employees collection is not empty", cartTrademarks, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        CartTrademark cartTrademark = new CartTrademark("Test", "Test");
        Long id = cartTrademarkDao.save(cartTrademark);
        CartTrademark cartTrademark1 = cartTrademarkDao.findOne(id);
        assertNotNull("FindById does not work", cartTrademark1);
    }
}