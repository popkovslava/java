package org.project.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.PagesDao;
import org.project.entity.Pages;
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
public class PagesDaoImplTest {

    @Autowired
    private PagesDao pagesDao;


    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", pagesDao);
    }

    @Test
    public void checkSaveEntity() {
        Long id = pagesDao.save(new Pages("Ivan"));
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Pages> employees = pagesDao.findAll();
        assertThat("Employees collection is not empty", employees, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Pages pter = new Pages("Pter");
        Long id = pagesDao.save(pter);
        Pages actualEntity = pagesDao.findOne(id);
        assertNotNull("FindById does not work", actualEntity);
    }
}