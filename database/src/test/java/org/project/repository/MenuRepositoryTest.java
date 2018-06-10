package org.project.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.config.TestConfiguration;
import org.project.entity.Menu;;
import org.project.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class MenuRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", menuRepository);
    }

    @Test
    public void checkFindById() {
        assertNotNull("Collection is  empty", menuRepository.findById(1L));
    }

    @Test
    public void checkFindAllById() {
        List<Long> menus = new ArrayList<>();
        menus.add(1l);
        menus.add(2l);
        menus.add(3L);
        menus.add(4l);
        assertNotNull("Collection is  empty", menuRepository.findAllById(menus));
    }

    @Test
    public void findAll() {
        assertNotNull("Id is null", menuRepository.findAll());
    }

    @Test
    public void delete() {
        Iterable<Menu> lists = menuRepository.findAll();
        List<Menu> list1 = new ArrayList<>();
        for (Menu list : lists) {
            menuRepository.delete(list);
            list1.add(list);
        }
        assertTrue(!list1.isEmpty());
    }
}