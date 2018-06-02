package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.TrademarkDao;
import org.project.entity.Trademark;
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
public class TrademarkDaoImplTest {

    @Autowired
    private TrademarkDao trademarkDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded",trademarkDao);
    }

    @Test
    public void checkSaveEntity() {
        Trademark trademark= new Trademark();
        trademark.setTitle("test");
        Long id = trademarkDao.save(trademark);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Trademark> trademarks=trademarkDao.findAll();
        assertThat("Employees collection is not empty",trademarks, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Trademark trademark= new Trademark();
        trademark.setTitle("test");
        Long id =trademarkDao.save(trademark);
        Trademark menu1 =trademarkDao.findOne(id);
        assertNotNull("FindById does not work", menu1);
    }
}