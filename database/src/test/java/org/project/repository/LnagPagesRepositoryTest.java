package org.project.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.config.TestConfiguration;
import org.project.entity.Lang;
import org.project.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;
import static org.testng.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class LnagPagesRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private LangRepository langRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", langRepository);
    }

    @Test
    public void checkFindById() {
        assertNotNull("Collection is  empty", langRepository.findById(1L));
    }

    @Test
    public void checkFindAllById() {
        List<Long> lang = new ArrayList<>();
        lang.add(1l);
        lang.add(2l);
        lang.add(3L);
        lang.add(4l);
        lang.add(5l);
        assertNotNull("Collection is  empty", langRepository.findAllById(lang));
    }

    @Test
    public void findAll() {
        assertNotNull("Id is null", langRepository.findAll());
    }

    @Test
    public void delete() {
        Iterable<Lang> lists = langRepository.findAll();
        List<Lang> list1 = new ArrayList<>();
        for (Lang list : lists) {
            langRepository.delete(list);
            list1.add(list);
        }
        assertTrue(!list1.isEmpty());
    }
}