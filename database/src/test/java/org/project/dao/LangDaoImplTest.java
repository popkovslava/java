package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.LangDao;
import org.project.entity.Lang;
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
public class LangDaoImplTest {

    @Autowired
    private LangDao langDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", langDao);
    }

    @Test
    public void checkSaveEntity() {
        Lang lang = new Lang();
        lang.setLn("test");
        Long id = langDao.save(lang);
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Lang> langs = langDao.findAll();
        assertThat("Employees collection is not empty", langs, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Lang lang = new Lang();
        lang.setLn("test");
        Long id = langDao.save(lang);
        Lang actualEntity = langDao.findOne(id);
        assertNotNull("FindById does not work", actualEntity);
    }
}