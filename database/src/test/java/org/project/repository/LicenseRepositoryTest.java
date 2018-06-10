package org.project.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.config.TestConfiguration;
import org.project.entity.License;
import org.project.util.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class LicenseRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private LicenseRepository licenseRepository;

    @Before
    public void init() {

        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", licenseRepository);
    }

    @Test
    public void checkFindById() {
        assertNotNull("Collection is  empty", licenseRepository.findById(1L));
    }

    @Test
    public void checkFindAllById() {
        License license = new License();
        List<Long> licenses = new ArrayList<>();
        license.setId(1L);
        license.setId(2L);
        license.setId(3L);
        license.setId(4L);
        assertNotNull("Collection is  empty", licenseRepository.findAllById(licenses));
    }

    @Test
    public void findAll() {
        assertNotNull("Id is null", licenseRepository.findAll());
    }

    @Test
    public void delete() {
        Iterable<License> lists = licenseRepository.findAll();
        List<License> list1 = new ArrayList<>();
        for (License list : lists) {
            licenseRepository.delete(list);
            list1.add(list);
        }
        assertTrue(!list1.isEmpty());
    }
}