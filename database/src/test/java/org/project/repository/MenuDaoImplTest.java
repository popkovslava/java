package org.project.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.config.TestConfiguration;
import org.project.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class MenuDaoImplTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Before
    public void init() {
        databaseHelper.prepareData();
    }

    @Test
    public void checkExisting() {
        // assertNotNull("Spring context is not loaded", menuRepository);
    }
}