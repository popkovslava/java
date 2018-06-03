package org.project.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.dao.Interface.MenuDao;
import org.project.entity.Menu;
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
public class MenuDaoImplTest {

    @Autowired
    private MenuDao menuDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", menuDao);
    }

    @Test
    public void checkSaveEntity() {
        Long id = menuDao.save(new Menu("test"));
        assertNotNull("Entity is not saved", id);
    }

    @Test
    public void checkFindAll() {
        List<Menu> menus = menuDao.findAll();
        assertThat("Employees collection is not empty", menus, hasSize(0));
    }

    @Test
    public void checkFindEntityById() {
        Menu menu = new Menu();
        menu.setTitle("test");
        Long id = menuDao.save(menu);
        Menu menu1 = menuDao.findOne(id);
        assertNotNull("FindById does not work", menu1);
    }
}